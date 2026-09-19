package main.java.com.loja.repository;

import main.java.com.loja.dto.ClienteResponse;
import main.java.com.loja.model.Cliente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClienteRepository {
    private static final Map<Long, Cliente> clientes = new HashMap<>();

    public ClienteResponse salvar(Cliente cliente) {
        this.clientes.put(cliente.getId(), cliente);
        return new ClienteResponse(
                cliente.getId(),
                cliente.getNome(),
                cliente.getEmail()
        );

    }

    public Cliente buscarPorId(Long id) {
        return this.clientes.get(id);
    }

    public ArrayList<Cliente> buscarTodos() {
        return new ArrayList<Cliente> (this.clientes.values());
    }

    public void deletar (Cliente cliente) {
        this.clientes.remove(cliente.getId());
    }

    public boolean existePorId(Long id) {
        return this.clientes.containsKey(id);
    }
}
