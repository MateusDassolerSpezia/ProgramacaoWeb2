/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author vinio
 */
import model.Loja;
import java.util.*;

public class LojaController {
    private Map<Integer, Loja> lojas = new HashMap<>();
    private int proximoId = 1;

    public Loja criar(Loja l) {
        l.setId(proximoId++); 
        lojas.put(l.getId(), l);
        return l;
    }

    public Loja buscar(int id) {
        return lojas.get(id);
    }

    public List<Loja> listar() {
        return new ArrayList<>(lojas.values());
    }

    public Loja atualizar(Loja l) {
        if (!lojas.containsKey(l.getId())) {
            throw new IllegalArgumentException("Loja não encontrada.");
        }
        lojas.put(l.getId(), l);
        return l;
    }

    public void remover(int id) {
        if (!lojas.containsKey(id)) {
            throw new IllegalArgumentException("Loja não encontrada.");
        }
        lojas.remove(id);
    }
}
