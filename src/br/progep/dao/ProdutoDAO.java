package br.progep.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.progep.domain.Produto;
import br.progep.util.EntityManagerUtil;

public class ProdutoDAO {

	EntityManager em = null;

	public void salvar(Produto produto) {

		em = EntityManagerUtil.getEntityManager();

		try {

			em.getTransaction().begin();

			em.persist(produto);

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
	public List<Produto> listar() {

		em = EntityManagerUtil.getEntityManager();

		List<Produto> produtos = null;

		try {
			em.getTransaction().begin();
			produtos = em.createQuery("FROM " + Produto.class.getName()).getResultList();
			em.getTransaction().commit();

		} catch (RuntimeException ex) {
			if (em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
			throw ex;
		} finally {
			em.close();
		}

		return produtos;
	}

	public Produto buscaPorCodigo(Long codigo) {

		em = EntityManagerUtil.getEntityManager();

		Produto produto = null;

		try {
			em.getTransaction().begin();
			produto = em.find(Produto.class, codigo);
			em.getTransaction().commit();

		} catch (RuntimeException ex) {
			if (em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
			throw ex;
		} finally {
			em.close();
		}

		return produto;
	}

	public void excluir(Produto produto) {

		em = EntityManagerUtil.getEntityManager();

		try {
			em.getTransaction().begin();
			em.remove(em.find(Produto.class, produto.getCodigo()));
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
	
	public void editar(Produto produto) {

		em = EntityManagerUtil.getEntityManager();

		try {

			em.getTransaction().begin();

			em.merge(produto);

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
