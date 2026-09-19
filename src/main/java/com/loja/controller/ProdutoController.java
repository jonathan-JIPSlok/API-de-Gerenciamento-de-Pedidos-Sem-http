package main.java.com.loja.controller;

import main.java.com.loja.dto.CriarProdutoRequest;
import main.java.com.loja.dto.PedidoResponse;
import main.java.com.loja.dto.ProdutoResponse;
import main.java.com.loja.service.ProdutoService;

public class ProdutoController {

    public ProdutoResponse criar(CriarProdutoRequest request) {
        return new ProdutoService().cadastrar(request);
    }
}
