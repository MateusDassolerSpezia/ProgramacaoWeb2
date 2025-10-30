package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Loja;

public class LojaController {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Clientes-PU");
	
	//POST
	public void inserir(Loja loja) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(loja);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
	
	//GET
	public List<Loja> listar() {
		EntityManager em = emf.createEntityManager();
		List<Loja> lojas = em.createQuery("FROM loja", Loja.class).getResultList();
		em.close();
		return lojas;
	}
	
	//GET ID
	public Loja buscarPorId(int id) {
		EntityManager em = emf.createEntityManager();
		Loja loja = em.find(Loja.class, id);
		em.close();
		return loja;
	}
	
	//PUT
	public void atualizar(Loja lojaAtualizada) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(lojaAtualizada);
			em.getTransaction().commit();;
		} finally {
			em.close();
		}
	}
	
	//DELETE
	public void deletar(int id) {
		EntityManager em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			Loja loja = em.find(Loja.class, id);
			if (loja != null) {
				em.remove(loja);
			}
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
}
