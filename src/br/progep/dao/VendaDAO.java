package br.progep.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.progep.domain.Venda;
import br.progep.util.EntityManagerUtil;

public class VendaDAO {
	
	EntityManager em = null;

	public void salvar(Venda venda) {

		em = EntityManagerUtil.getEntityManager();

		try {

			em.getTransaction().begin();

			em.persist(venda);

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
	public List<Venda> listar() {

		em = EntityManagerUtil.getEntityManager();

		List<Venda> vendas = null;

		try {
			em.getTransaction().begin();
			vendas = em.createQuery("FROM " + Venda.class.getName()).getResultList();
			em.getTransaction().commit();

		} catch (RuntimeException ex) {
			if (em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
			throw ex;
		} finally {
			em.close();
		}

		return vendas;
	}

	public Venda buscaPorCodigo(Long codigo) {

		em = EntityManagerUtil.getEntityManager();

		Venda venda = null;

		try {
			em.getTransaction().begin();
			venda = em.find(Venda.class, codigo);
			em.getTransaction().commit();

		} catch (RuntimeException ex) {
			if (em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
			throw ex;
		} finally {
			em.close();
		}

		return venda;
	}

	public void excluir(Venda venda) {

		em = EntityManagerUtil.getEntityManager();

		try {
			em.getTransaction().begin();
			em.remove(em.find(Venda.class, venda.getCodigo()));
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
	
	public void editar(Venda venda) {

		em = EntityManagerUtil.getEntityManager();

		try {

			em.getTransaction().begin();

			em.merge(venda);

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
