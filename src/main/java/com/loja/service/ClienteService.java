package main.java.com.loja.service;

import main.java.com.loja.dto.ClienteResponse;
import main.java.com.loja.dto.CriarClienteRequest;
import main.java.com.loja.model.Cliente;
import main.java.com.loja.repository.ClienteRepository;

import java.util.Random;

public class ClienteService {
    private ClienteRepository clienteRepository = new  ClienteRepository();

    public ClienteResponse criar (CriarClienteRequest request) {
        Cliente cliente = new Cliente(
                request.getNome(),
                request.getEmail()
        );

        return clienteRepository.salvar(cliente);
    }
}
