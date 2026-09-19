package main.java.com.loja.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pedido {
    private final Long id;
    private Cliente cliente;
    private ArrayList<Produto> produtos = new ArrayList<>();
    private StatusPedido status;

    public Pedido(Cliente cliente, List<Produto> produtos) {
        this.id = new Random().nextLong();
        this.cliente =  cliente;
        this.produtos.addAll(produtos);
        this.status = StatusPedido.CRIADO;

    }

    public void adicionarProdutos(List<Produto> produtos) {
        this.produtos.addAll(produtos);
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
        return produtos;
    }
    public StatusPedido getStatus() {
        return status;
    }
    public Cliente getCliente() {
        return cliente;
    }
}
