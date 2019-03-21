package br.progep.main;

import javax.persistence.EntityManager;

import br.progep.util.EntityManagerUtil;

public class GeraTabela {

	public static void main(String[] args) {

		EntityManager em = EntityManagerUtil.getEntityManager();
		
		em.getTransaction().begin();
		em.close();
	}

}
