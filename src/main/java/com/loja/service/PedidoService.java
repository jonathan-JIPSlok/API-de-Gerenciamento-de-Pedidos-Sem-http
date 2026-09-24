package main.java.com.loja.service;

import main.java.com.loja.dto.CriarPedidoRequest;
import main.java.com.loja.dto.PedidoResponse;
import main.java.com.loja.model.Pedido;
import main.java.com.loja.model.Produto;
import main.java.com.loja.model.StatusPedido;
import main.java.com.loja.repository.ClienteRepository;
import main.java.com.loja.repository.PedidoRepository;
import main.java.com.loja.repository.ProdutoRepository;

import java.util.*;

public class PedidoService {
    private final PedidoRepository pedidoRepository = new PedidoRepository();
    private final ProdutoRepository produtoRepository = new ProdutoRepository();
    private final ClienteRepository clienteRepository = new ClienteRepository();

    public PedidoResponse buscarPorId(Long id) {
        Pedido pedido = pedidoRepository.buscarPorId(id);
        return criarResponse(pedido);
    }

    public PedidoResponse cancelar(Long id) {
        if (pedidoRepository.buscarPorId( id ).getStatus() == StatusPedido.ENTREGUE) {
            throw new RuntimeException("Pedido Entergue! não pode ser cancelado!");
        } else if (pedidoRepository.buscarPorId( id ).getStatus() == StatusPedido.CANCELADO) {
            throw new RuntimeException("Pedido já foi Cancelado!");
        }

        pedidoRepository.buscarPorId( id ).getProdutos().forEach(produto -> {
            produtoRepository.buscarPorId(produto.getId()).adicionarEstoque(produto.getEstoque());
        });

        Pedido pedido = pedidoRepository.buscarPorId( id );
        pedido.alterarStatus(StatusPedido.CANCELADO);
        pedidoRepository.salvar(pedido);

        return criarResponse(pedido);
    }

    public PedidoResponse criar(CriarPedidoRequest request) {
        if (!clienteRepository.existePorId( request.getClienteId() )){
            throw new RuntimeException("Cliente inexistente!");
        }
        existeProdutoEEstoque(request);


        Pedido pedido = new Pedido(
                clienteRepository.buscarPorId(request.getClienteId()),
                criarListaProdutos(request.getProdutosIds())
        );

        removerEstoque(pedido.getProdutos());

        Pedido pedidoSalvo = pedidoRepository.salvar(pedido);
        return criarResponse(pedidoSalvo);
    }

    public List<PedidoResponse> listarTodos() {
        List<PedidoResponse> pedidos = new ArrayList<>();
        pedidoRepository.buscarTodos().forEach(pedido -> {
            pedidos.add( criarResponse(pedido) );
        });

        return pedidos;
    }

    private void existeProdutoEEstoque(CriarPedidoRequest request) {
        request.getProdutosIds().keySet().forEach( valor -> {
            if (!produtoRepository.existePorId(valor) ) {
                throw new RuntimeException("Produto Inexistente!");
            } else if (produtoRepository.buscarPorId(valor).getEstoque() < request.getProdutosIds().get(valor)) {
                throw new RuntimeException("Estoque Insuficiente!");
            }
        });
    }

    private List<Produto> criarListaProdutos(Map<Long, Integer> produtos)  {
        List<Produto> produtoList = new ArrayList<>();

        produtos.keySet().forEach( produtoId -> {
            Produto produto = produtoRepository.buscarPorId(produtoId);
            produtoList.add(
                    new Produto(
                            produto.getId(),
                            produto.getNome(),
                            produto.getPreco(),
                            produtos.get(produtoId)
                    )
            );
        });
        return produtoList;
    }

    private void removerEstoque(ArrayList<Produto> produtos) {
        for (Produto produto: produtos) {
            produtoRepository.buscarPorId(produto.getId()).removerEstoque(produto.getEstoque());
        }
    }

    public PedidoResponse criarResponse(Pedido pedido) {
        return new PedidoResponse(
                pedido.getId(),
                pedido.getCliente(),
                pedido.getProdutos(),
                pedido.calcularTotal(),
                pedido.getStatus()
        );
    }


}
