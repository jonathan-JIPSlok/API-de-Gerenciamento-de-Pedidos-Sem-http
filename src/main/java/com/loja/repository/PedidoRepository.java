package main.java.com.loja.repository;

import main.java.com.loja.dto.PedidoResponse;
import main.java.com.loja.model.Pedido;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PedidoRepository {
    private static final Map<Long, Pedido> pedidos = new HashMap<>();

    public Pedido salvar(Pedido pedido) {
        pedidos.put(pedido.getId(), pedido);
        return pedidos.get(pedido.getId());
    }

    public Pedido buscarPorId(Long id) {
        if (!existePorId(id)) {
            throw new RuntimeException("Id inexistente");
        }
        return pedidos.get ( id );
    }

    public List<Pedido> buscarTodos() {
        return new ArrayList<>(pedidos.values());
    }

    public void deletar(PedidoResponse pedido) {
        pedidos.remove(pedido.getId());
    }

    public boolean existePorId(Long id) {
        return pedidos.containsKey(id);
    }
}
