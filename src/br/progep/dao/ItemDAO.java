package br.progep.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.progep.domain.Item;
import br.progep.util.EntityManagerUtil;

public class ItemDAO {

	EntityManager em = null;

	public void salvar(Item item) {

		em = EntityManagerUtil.getEntityManager();

		try {

			em.getTransaction().begin();

			em.persist(item);

			em.getTransaction().commit();

		} catch (RuntimeException ex) {

			if (em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
			throw ex;
		} finally {
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Item> listar() {

		em = EntityManagerUtil.getEntityManager();

		List<Item> itens = null;

		try {
			em.getTransaction().begin();
			itens = em.createQuery("FROM " + Item.class.getName()).getResultList();
			em.getTransaction().commit();

		} catch (RuntimeException ex) {
			if (em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
			throw ex;
		} finally {
			em.close();
		}

		return itens;
	}

	public Item buscaPorCodigo(Long codigo) {

		em = EntityManagerUtil.getEntityManager();

		Item item = null;

		try {
			em.getTransaction().begin();
			item = em.find(Item.class, codigo);
			em.getTransaction().commit();

		} catch (RuntimeException ex) {
			if (em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
			throw ex;
		} finally {
			em.close();
		}

		return item;
	}

	public void excluir(Item item) {

		em = EntityManagerUtil.getEntityManager();

		try {
			em.getTransaction().begin();
			em.remove(em.find(Item.class, item.getCodigo()));
			em.getTransaction().commit();

		} catch (RuntimeException ex) {
			if (em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
			throw ex;
		} finally {
			em.close();
		}
	}
	
	public void editar(Item item) {

		em = EntityManagerUtil.getEntityManager();

		try {

			em.getTransaction().begin();

			em.merge(item);

			em.getTransaction().commit();

		} catch (RuntimeException ex) {

			if (em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
			throw ex;
		} finally {
			em.close();
		}
	}
}
