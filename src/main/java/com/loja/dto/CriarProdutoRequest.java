package main.java.com.loja.dto;

import java.math.BigDecimal;

public class CriarProdutoRequest {
    private String nome;
    private BigDecimal preco;
    private int estoque;

    public CriarProdutoRequest(String nome, BigDecimal preco, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public String getNome() {return nome;}
    public BigDecimal getPreco() {return preco;}
    public int getEstoque() {return estoque;}
}
