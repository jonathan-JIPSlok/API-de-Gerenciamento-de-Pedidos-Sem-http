package main.java.com.loja.dto;

import java.math.BigDecimal;

public class ProdutoResponse {
    private final Long id;
    private final String nome;
    private final BigDecimal preco;
    private final int estoque;

    public ProdutoResponse(Long id, String nome, BigDecimal preco, int estoque) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    public BigDecimal getPreco() {
        return preco;
    }
    public int getEstoque() {
        return estoque;
    }
}
