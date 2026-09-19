package main.java.com.loja.service.pedido;

import main.java.com.loja.dto.PedidoResponse;
import main.java.com.loja.repository.PedidoRepository;

public class PedidoBuscarIdService {

    PedidoRepository pedidoRepository = new PedidoRepository();

    public PedidoResponse buscarPorId(Long id) {
        if (!pedidoRepository.existePorId( id )) {
            throw new RuntimeException("Pedido inexistente!");
        }
        return pedidoRepository.buscarPorId( id );
    }
}
