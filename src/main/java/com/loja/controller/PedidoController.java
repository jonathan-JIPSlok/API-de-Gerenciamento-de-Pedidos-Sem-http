package main.java.com.loja.controller;

import main.java.com.loja.dto.CriarPedidoRequest;
import main.java.com.loja.dto.PedidoResponse;
import main.java.com.loja.service.pedido.PedidoBuscarIdService;
import main.java.com.loja.service.pedido.PedidoCancelarService;
import main.java.com.loja.service.pedido.PedidoCriarService;
import main.java.com.loja.service.pedido.PedidoListarService;

import java.util.List;

public class PedidoController {
    private final PedidoCriarService pedidoCriarService = new PedidoCriarService();
    private final PedidoBuscarIdService pedidoBuscarIdService = new PedidoBuscarIdService();
    private final PedidoListarService pedidoListarService = new PedidoListarService();
    private final PedidoCancelarService pedidoCancelarService = new PedidoCancelarService();

    public PedidoResponse criar(CriarPedidoRequest request) {
        return pedidoCriarService.criar(request);
    }

    public PedidoResponse buscarPorId(Long id) {
        return pedidoBuscarIdService.buscarPorId(id);
    }

    public List<PedidoResponse> buscarTodos() {
        return pedidoListarService.listarTodos();
    }

    public PedidoResponse cancelar (Long id) {
        return pedidoCancelarService.cancelar( id );
    }
}
