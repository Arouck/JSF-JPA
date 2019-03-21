package br.progep.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.progep.domain.Funcionario;
import br.progep.util.EntityManagerUtil;

public class FuncionarioDAO {
	
	EntityManager em = null;

	public void salvar(Funcionario funcionario) {

		em = EntityManagerUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(funcionario);
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
	public List<Funcionario> listar() {
		
		em = EntityManagerUtil.getEntityManager();

		List<Funcionario> funcionarios = null;

		try {
			em.getTransaction().begin();
			funcionarios = em.createQuery("FROM " + Funcionario.class.getName()).getResultList();
			em.getTransaction().commit();

		} catch (RuntimeException ex) {

			if (em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
			throw ex;
		} finally {
			em.close();
		}

		return funcionarios;
	}

	public Funcionario buscaPorCodigo(Long codigo) {
		
		em = EntityManagerUtil.getEntityManager();
		
		Funcionario funcionario = null;

		try {
			em.getTransaction().begin();
			/*Query query = em.createQuery("SELECT fabricante FROM " + Fabricante.class.getName()
					+ " as fabricante WHERE fabricante.codigo = :codigo");
			query.setParameter("codigo", codigo);*/
			funcionario = /*(Fabricante) query.getSingleResult();*/ em.find(Funcionario.class, codigo);
			em.getTransaction().commit();

		} catch (RuntimeException ex) {
			ex.printStackTrace();
		}
		
		em.close();

		return funcionario;
	}
	
	public void excluir(Funcionario funcionario) {
		
		em = EntityManagerUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			em.remove(em.find(Funcionario.class, funcionario.getCodigo()));
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
	
	public void editar(Funcionario funcionario) {

		em = EntityManagerUtil.getEntityManager();
		
		try {
			em.getTransaction().begin();
			em.merge(funcionario);
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
