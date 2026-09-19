package main.java.com.loja.service.pedido;

import main.java.com.loja.dto.PedidoResponse;
import main.java.com.loja.repository.PedidoRepository;

import java.util.List;

public class PedidoListarService {

    private PedidoRepository pedidoRepository = new PedidoRepository();

    public List<PedidoResponse> listarTodos() {
        return pedidoRepository.buscarTodos();
    }
}
