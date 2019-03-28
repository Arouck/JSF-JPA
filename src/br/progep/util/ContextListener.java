package br.progep.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		EntityManagerUtil.getEntityManager().close();
	}
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		EntityManagerUtil.getEntityManager().getTransaction().begin();
	}
}
