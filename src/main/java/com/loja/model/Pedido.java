package main.java.com.loja.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pedido {
    private final Long id;
    private final Cliente cliente;
    private final ArrayList<Produto> produtos = new ArrayList<>();
    private StatusPedido status;

    public Pedido(Cliente cliente, List<Produto> produtos) {
        this.id = new Random().nextLong();
        this.cliente =  cliente;
        produtos.forEach(this::adicionarProduto);
        this.status = StatusPedido.CRIADO;

    }

    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public void removerProduto(Produto produto) {
        this.produtos.remove(produto);
    }

    public BigDecimal calcularTotal() {
        BigDecimal valorTotal = new BigDecimal("0");
        for (Produto produto : produtos) {
            valorTotal = valorTotal.add(produto.getPreco());
        }
        return valorTotal;
    }

    public void alterarStatus(StatusPedido status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }
    public ArrayList<Produto> getProdutos() {
        return new ArrayList<>(this.produtos);
    }
    public StatusPedido getStatus() {
        return status;
    }
    public Cliente getCliente() {
        return cliente;
    }
}
