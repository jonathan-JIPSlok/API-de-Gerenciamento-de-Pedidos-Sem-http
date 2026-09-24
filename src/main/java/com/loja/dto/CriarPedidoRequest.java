package main.java.com.loja.dto;

import java.util.HashMap;
import java.util.Map;

public class CriarPedidoRequest {
    private final Long clienteId;
    private final Map<Long, Integer> produtosIdQuantiade= new HashMap<>();

    public CriarPedidoRequest(Long clienteId, Map<Long, Integer> produtos) {
        this.clienteId = clienteId;
        this.produtosIdQuantiade.putAll(produtos);
    }

    public Long getClienteId() {return clienteId;}
    public Map<Long, Integer> getProdutosIds() {return produtosIdQuantiade;}
}
