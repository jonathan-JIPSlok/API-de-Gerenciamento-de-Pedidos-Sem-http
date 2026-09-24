package main.java.com.loja.model;

import java.math.BigDecimal;
import java.util.Random;

public class Produto {
    private final Long id;
    private String nome;
    private BigDecimal preco;
    private int estoque;

    public Produto(String nome, BigDecimal preco, int estoque) {
        this.id = new Random().nextLong();
        setNome(nome);
        setPreco(preco);
        adicionarEstoque(estoque);
    }
    public Produto(Long id, String nome, BigDecimal preco, int estoque) {
        this.id = id;
        setNome(nome);
        setPreco(preco);
        adicionarEstoque(estoque);
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome deve ser informado");
        }
        this.nome = nome;
    }

    public void setPreco(BigDecimal preco) {
        if (preco == null || preco.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Preco deve ser maior do que zero");
        }
        this.preco = preco;
    }

    public void adicionarEstoque(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero");
        }
        this.estoque += quantidade;
    }

    public void removerEstoque(int quantidade) {
        if (quantidade > this.estoque) {
            throw new IllegalArgumentException("Quantidade deve ser menor que estoque");
        }
        this.estoque -= quantidade;
    }

    public BigDecimal getPreco() {
        return this.preco;
    }

    public Long getId() {
        return this.id;
    }

    public String getNome() {return this.nome;}

    public int getEstoque() {return this.estoque;}

}
