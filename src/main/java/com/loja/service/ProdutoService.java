package main.java.com.loja.service;

import main.java.com.loja.dto.CriarProdutoRequest;
import main.java.com.loja.dto.ProdutoResponse;
import main.java.com.loja.model.Produto;
import main.java.com.loja.repository.ProdutoRepository;

import java.util.Random;

public class ProdutoService {

    private ProdutoRepository produtoRepository = new ProdutoRepository();

    public ProdutoResponse cadastrar (CriarProdutoRequest request) {
        Produto produto = new Produto(
                request.getNome(),
                request.getPreco(),
                request.getEstoque()
        );

        return produtoRepository.salvar(produto);
    }
}
