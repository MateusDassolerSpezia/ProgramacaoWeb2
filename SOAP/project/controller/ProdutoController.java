/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author vinio
 */
import model.Produto;
import java.util.*;

public class ProdutoController {
    private Map<Integer, Produto> produtos = new HashMap<>();
    private int proximoId = 1;

    public Produto criar(Produto p) {
        p.setId(proximoId++); 
        produtos.put(p.getId(), p);
        return p;
    }

    public Produto buscar(int id) {
        return produtos.get(id);
    }

    public List<Produto> listar() {
        return new ArrayList<>(produtos.values());
    }

    public Produto atualizar(Produto p) {
        if (!produtos.containsKey(p.getId())) {
            throw new IllegalArgumentException("Produto não encontrado.");
        }
        produtos.put(p.getId(), p);
        return p;
    }

    public void remover(int id) {
        if (!produtos.containsKey(id)) {
            throw new IllegalArgumentException("Produto não encontrado.");
        }
        produtos.remove(id);
    }
}