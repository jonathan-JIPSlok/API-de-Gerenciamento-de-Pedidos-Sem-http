package main.java.com.loja.dto;

import main.java.com.loja.model.Cliente;
import main.java.com.loja.model.Produto;
import main.java.com.loja.model.StatusPedido;

import java.math.BigDecimal;
import java.util.ArrayList;

public class PedidoResponse {
    private long id;
    private Cliente cliente;
    private final ArrayList<Produto> produtos = new ArrayList<>();
    private BigDecimal total;
    private StatusPedido status;

    public PedidoResponse(Long id, Cliente cliente, ArrayList<Produto> produtos, BigDecimal total, StatusPedido status) {
        this.id = id;
        this.cliente = cliente;
        this.produtos.addAll(produtos);
        this.total = total;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public StatusPedido getStatus() {
        return status;
    }
}
