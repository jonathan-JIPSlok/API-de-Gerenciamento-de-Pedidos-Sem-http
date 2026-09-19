package main.java.com.loja.dto;

import java.math.BigDecimal;

public class ProdutoResponse {
    private Long id;
    private String nome;
    private BigDecimal preco;
    private int estoque;

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
