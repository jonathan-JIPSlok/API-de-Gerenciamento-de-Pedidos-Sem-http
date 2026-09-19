package main.java.com.loja.repository;

import main.java.com.loja.dto.PedidoResponse;
import main.java.com.loja.model.Pedido;
import main.java.com.loja.model.StatusPedido;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PedidoRepository {
    private static final Map<Long, Pedido> pedidos = new HashMap<>();

    public PedidoResponse salvar(Pedido pedido) {
        pedidos.put(pedido.getId(), pedido);
        return new PedidoResponse(
                pedido.getId(),
                pedido.getCliente(),
                pedido.getProdutos(),
                pedido.calcularTotal(),
                pedido.getStatus()
        );
    }

    public PedidoResponse buscarPorId(Long id) {

        Pedido pedido = pedidos.get ( id );

        return new PedidoResponse(
                pedido.getId(),
                pedido.getCliente(),
                pedido.getProdutos(),
                pedido.calcularTotal(),
                pedido.getStatus()
        );

    }

    public List<PedidoResponse> buscarTodos() {
        List<PedidoResponse> pedidosResponse = new ArrayList<>();
        pedidos.values().forEach(pedido -> {
           pedidosResponse.add(
                   new  PedidoResponse(
                           pedido.getId(),
                           pedido.getCliente(),
                           pedido.getProdutos(),
                           pedido.calcularTotal(),
                           pedido.getStatus()
                   )
           );
        });

        return pedidosResponse;
    }

    public void deletar(PedidoResponse pedido) {
        pedidos.remove(pedido.getId());
    }

    public PedidoResponse cancelar(Long id) {
        pedidos.get(id).alterarStatus(StatusPedido.CANCELADO);
        return new PedidoResponse(
                pedidos.get(id).getId(),
                pedidos.get(id).getCliente(),
                pedidos.get(id).getProdutos(),
                pedidos.get(id).calcularTotal(),
                pedidos.get(id).getStatus()
        );
    }

    public boolean existePorId(Long id) {
        return pedidos.containsKey(id);
    }
}
