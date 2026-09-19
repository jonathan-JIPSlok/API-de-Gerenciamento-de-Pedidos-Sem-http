package main.java.com.loja.repository;

import main.java.com.loja.dto.ProdutoResponse;
import main.java.com.loja.model.Produto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ProdutoRepository {
    private static final Map<Long, Produto> produtos = new HashMap<>();

    public ProdutoResponse salvar (Produto produto) {
        this.produtos.put(produto.getId(), produto);
        return new ProdutoResponse(
                produto.getId(),
                produto.getNome(),
                produto.getPreco(),
                produto.getEstoque()
        );
    }

    public void deletar(Produto produto) {
        this.produtos.remove(produto.getId());
    }

    public ArrayList<Produto> buscarTodos() {
        return new ArrayList<Produto>(this.produtos.values());
    }

    public Produto buscarPorId(Long id) {
        return this.produtos.get(id);
    }

    public boolean existePorId(Long id) {
        return this.produtos.containsKey(id);
    }
}
