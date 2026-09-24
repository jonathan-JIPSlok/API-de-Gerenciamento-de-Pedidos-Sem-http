package main.java.com.loja.controller;

import main.java.com.loja.dto.ClienteResponse;
import main.java.com.loja.dto.CriarClienteRequest;
import main.java.com.loja.service.ClienteService;

public class ClienteController {
    public ClienteResponse criar(CriarClienteRequest request) {
        return new ClienteService().criar(request);
    }
}
