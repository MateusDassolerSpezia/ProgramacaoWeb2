package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Produto;

public class ProdutoController {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Clientes-PU");

    // POST
    public void inserir(Produto produto) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(produto);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // GET
    public List<Produto> listar() {
        EntityManager em = emf.createEntityManager();
        List<Produto> produtos = em.createQuery("FROM Produto", Produto.class).getResultList();
        em.close();
        return produtos;
    }

    // GET ID
    public Produto buscarPorId(int id) {
        EntityManager em = emf.createEntityManager();
        Produto produto = em.find(Produto.class, id);
        em.close();
        return produto;
    }

    // PUT
    public void atualizar(Produto produtoAtualizado) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(produtoAtualizado);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    // DELETE
    public void deletar(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Produto produto = em.find(Produto.class, id);
            if (produto != null) {
                em.remove(produto);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
