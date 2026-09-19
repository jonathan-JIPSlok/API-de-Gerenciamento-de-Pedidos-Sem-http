package main.java.com.loja.service.pedido;

import main.java.com.loja.dto.CriarPedidoRequest;
import main.java.com.loja.dto.PedidoResponse;
import main.java.com.loja.model.Pedido;
import main.java.com.loja.model.Produto;
import main.java.com.loja.repository.ClienteRepository;
import main.java.com.loja.repository.PedidoRepository;
import main.java.com.loja.repository.ProdutoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PedidoCriarService {
    private final PedidoRepository pedidoRepository = new PedidoRepository();
    private final ProdutoRepository produtoRepository = new ProdutoRepository();
    private final ClienteRepository clienteRepository = new ClienteRepository();

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

        return pedidoRepository.salvar(pedido);
    }

    private void existeProdutoEEstoque(CriarPedidoRequest request) {
        request.getProdutosIds().keySet().forEach( valor -> {
            if (!produtoRepository.existePorId(valor) ) {
                System.out.println("Produto inexistente!");
            } else if (produtoRepository.buscarPorId(valor).getEstoque() < request.getProdutosIds().get(valor)) {
                System.out.println("Estoque insuficiente!");
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
                            produtos.get(produtoId).intValue()
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
}
