package main.java.com.loja.controller;

import main.java.com.loja.dto.CriarPedidoRequest;
import main.java.com.loja.dto.PedidoResponse;
import main.java.com.loja.service.PedidoService;

import java.util.List;

public class PedidoController {
    private final PedidoService pedidoService = new PedidoService();

    public PedidoResponse criar(CriarPedidoRequest request) {
        return pedidoService.criar(request);
    }

    public PedidoResponse buscarPorId(Long id) {
        return pedidoService.buscarPorId(id);
    }

    public List<PedidoResponse> buscarTodos() {
        return pedidoService.listarTodos();
    }

    public PedidoResponse cancelar (Long id) {
        return pedidoService.cancelar( id );
    }
}
