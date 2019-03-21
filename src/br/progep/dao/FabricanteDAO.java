package br.progep.dao;

import java.util.List;

import javax.persistence.EntityManager;
//import javax.persistence.Query;

import br.progep.domain.Fabricante;
import br.progep.util.EntityManagerUtil;

public class FabricanteDAO {
	
	EntityManager em;

	public void salvar(Fabricante fabricante) {

		em = EntityManagerUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(fabricante);
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
	public List<Fabricante> listar() {
		
		em = EntityManagerUtil.getEntityManager();

		List<Fabricante> fabricantes = null;

		try {
			em.getTransaction().begin();
			fabricantes = em.createQuery("FROM " + Fabricante.class.getName()).getResultList();
			em.getTransaction().commit();

		} catch (RuntimeException ex) {

			if (em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
			throw ex;
		} finally {
			em.close();
		}

		return fabricantes;
	}

	public Fabricante buscaPorCodigo(Long codigo) {
		
		em = EntityManagerUtil.getEntityManager();
		
		Fabricante fabricante = null;

		try {
			em.getTransaction().begin();
			/*Query query = em.createQuery("SELECT fabricante FROM " + Fabricante.class.getName()
					+ " as fabricante WHERE fabricante.codigo = :codigo");
			query.setParameter("codigo", codigo);*/
			fabricante = /*(Fabricante) query.getSingleResult();*/ em.find(Fabricante.class, codigo);
			em.getTransaction().commit();

		} catch (RuntimeException ex) {

			if (em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
			throw ex;
		} finally {
			em.close();
		}
		
		return fabricante;
	}
	
	public void excluir(Fabricante fabricante) {
		
		em = EntityManagerUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			em.remove(em.find(Fabricante.class, fabricante.getCodigo()));
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
	
	/*public void excluirPorCodigo(Long codigo) {
		
		em = EntityManagerUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			em.remove(em.find(Fabricante.class, codigo));
			em.getTransaction().commit();
			em.close();

		} catch (RuntimeException ex) {
			ex.printStackTrace();
		}
	}*/
	
	public void editar(Fabricante fabricante) {

		em = EntityManagerUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			em.merge(fabricante);
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