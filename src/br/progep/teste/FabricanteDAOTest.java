package br.progep.teste;

import java.util.List;

import org.junit.jupiter.api.Test;

import br.progep.dao.FabricanteDAO;
import br.progep.domain.Fabricante;

class FabricanteDAOTest {

	@Test
	void testSalvar() {
		Fabricante fabricante1 = new Fabricante();
		Fabricante fabricante2 = new Fabricante();
		
		fabricante1.setDescricao("Y");
		fabricante2.setDescricao("T");
		
		FabricanteDAO dao = new FabricanteDAO();
		
		dao.salvar(fabricante1);
		dao.salvar(fabricante2);
		
	}
	
	//@Test
	void testListar() {
		FabricanteDAO dao = new FabricanteDAO();
		List<Fabricante> fabricantes = dao.listar();
		
		for(Fabricante fabricante : fabricantes) {
			System.out.println(fabricante.toString());
		}
		
 	}
	
	//@Test
	void testBuscarPorCodigo() {
		FabricanteDAO dao = new FabricanteDAO();
		Fabricante f1 = dao.buscaPorCodigo(4L);
		
		System.out.println(f1.toString());
	}
	
	//@Test
	void testExcluir() {
		FabricanteDAO dao = new FabricanteDAO();
		Fabricante fabricante = dao.buscaPorCodigo(6L);
		dao.excluir(fabricante);
	}
	
	//@Test
	/*void testExcluirPorCodigo() {
		FabricanteDAO dao = new FabricanteDAO();
		dao.excluirPorCodigo(3L);
		
	}*/
	
	//@Test
	void testEditar() {
		Fabricante fabricante = new Fabricante();
		
		FabricanteDAO dao = new FabricanteDAO();
		
		fabricante = dao.buscaPorCodigo(2L);
		
		fabricante.setDescricao("M");
		
		dao.editar(fabricante);
	}

}
