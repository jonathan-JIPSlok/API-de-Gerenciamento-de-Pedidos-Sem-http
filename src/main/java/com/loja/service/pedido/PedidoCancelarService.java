package main.java.com.loja.service.pedido;

import main.java.com.loja.dto.PedidoResponse;
import main.java.com.loja.model.StatusPedido;
import main.java.com.loja.repository.PedidoRepository;
import main.java.com.loja.repository.ProdutoRepository;

public class PedidoCancelarService {

    private final PedidoRepository pedidoRepository =  new PedidoRepository();
    private final ProdutoRepository produtoRepository = new ProdutoRepository();

    public PedidoResponse cancelar(Long id) {
        if (!pedidoRepository.existePorId( id )) {
            throw new RuntimeException("Pedido não existente");
        } else if (pedidoRepository.buscarPorId( id ).getStatus() == StatusPedido.ENTREGUE) {
            throw new RuntimeException("Pedido Entergue! não pode ser cancelado!");
        }

        pedidoRepository.buscarPorId( id ).getProdutos().forEach(produto -> {
           produtoRepository.buscarPorId(produto.getId()).adicionarEstoque(produto.getEstoque());
        });

        return pedidoRepository.cancelar( id );
    }
}
