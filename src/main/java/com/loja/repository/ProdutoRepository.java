package main.java.com.loja.repository;

import main.java.com.loja.model.Produto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProdutoRepository {
    private static final Map<Long, Produto> produtos = new HashMap<>();

    public Produto salvar (Produto produto) {
        return produtos.put(produto.getId(), produto);
    }

    public void deletar(Produto produto) {
        produtos.remove(produto.getId());
    }

    public ArrayList<Produto> buscarTodos() {
        return new ArrayList<>(produtos.values());
    }

    public Produto buscarPorId(Long id) {
        return produtos.get(id);
    }

    public boolean existePorId(Long id) {
        return produtos.containsKey(id);
    }
}
