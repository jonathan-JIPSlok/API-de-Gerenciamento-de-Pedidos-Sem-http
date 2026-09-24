package main.java.com.loja.repository;

import main.java.com.loja.model.Cliente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ClienteRepository {
    private static final Map<Long, Cliente> clientes = new HashMap<>();

    public Cliente salvar(Cliente cliente) {
        clientes.put(cliente.getId(), cliente);
        return cliente;

    }

    public Cliente buscarPorId(Long id) {
        return clientes.get(id);
    }

    public ArrayList<Cliente> buscarTodos() {
        return new ArrayList<> (clientes.values());
    }

    public void deletar (Cliente cliente) {
        clientes.remove(cliente.getId());
    }

    public boolean existePorId(Long id) {
        return clientes.containsKey(id);
    }
}
