package main.java.com.loja;

import main.java.com.loja.controller.ClienteController;
import main.java.com.loja.controller.PedidoController;
import main.java.com.loja.controller.ProdutoController;
import main.java.com.loja.dto.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CriarClienteRequest clienteRequest = new CriarClienteRequest(
                "Jonathan",
                "JonathanPoli17@gmail.com"
        );

        CriarProdutoRequest produtoRequest = new CriarProdutoRequest(
                "Arroz",
                new  BigDecimal("12.00"),
                20
        );

        CriarProdutoRequest produtoRequest2 = new CriarProdutoRequest(
                "Feijão",
                new  BigDecimal("24.00"),
                11
        );

        ClienteController clienteController = new ClienteController();
        ProdutoController produtoController = new ProdutoController();
        PedidoController pedidoController = new PedidoController();

        ClienteResponse clienteJonathan = clienteController.criar(clienteRequest);
        ProdutoResponse produtoArroz = produtoController.criar(produtoRequest);
        ProdutoResponse produtoFeijao = produtoController.criar(produtoRequest2);

        Map<Long, Integer> produtosPedido1 = new HashMap<>();
        produtosPedido1.put(produtoArroz.getId(), 10);
        produtosPedido1.put(produtoFeijao.getId(), 5);

        CriarPedidoRequest criarPedidoRequest = new CriarPedidoRequest(
                clienteJonathan.getId(),
                produtosPedido1
        );

        PedidoResponse pedido1 = pedidoController.criar(criarPedidoRequest);

        System.out.println(pedidoController.buscarPorId(pedido1.getId()).getStatus());

        pedidoController.buscarTodos().forEach(pedido -> {
            pedido.getProdutos().forEach(produto -> {
                System.out.println(produto.getId() + " - " + produto.getNome());
            });
            System.out.println("Total: R$" + pedido.getTotal());
        });

        pedidoController.cancelar(pedido1.getId());
        System.out.println(pedidoController.buscarPorId(pedido1.getId()).getStatus());

    }
}
