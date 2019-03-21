package br.progep.teste;

import java.util.List;

import org.junit.jupiter.api.Test;

import br.progep.dao.FuncionarioDAO;
import br.progep.domain.Funcionario;

class FuncionarioDAOTest {

	//@Test
	void testSalvar() {
		Funcionario funcionario1 = new Funcionario();
		Funcionario funcionario2 = new Funcionario();
		
		funcionario1.setNome("A");
		funcionario1.setFuncao("F1");
		funcionario1.setSenha("123");
		funcionario1.setCpf("405.592.790-86");
		
		funcionario2.setNome("A");
		funcionario2.setFuncao("F1");
		funcionario2.setSenha("123");
		funcionario2.setCpf("155.940.090-00");
		
		FuncionarioDAO dao = new FuncionarioDAO();
		
		dao.salvar(funcionario1);
		dao.salvar(funcionario2);
		
	}
	
	//@Test
	void testListar() {
		FuncionarioDAO dao = new FuncionarioDAO();
		List<Funcionario> funcionarios = dao.listar();
		
		for(Funcionario funcionario : funcionarios) {
			System.out.println(funcionario.toString());
		}
		
 	}
	
	//@Test
	void testBuscarPorCodigo() {
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario f1 = dao.buscaPorCodigo(4L);
		
		System.out.println(f1.toString());
	}
	
	//@Test
	void testExcluir() {
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario funcionario = dao.buscaPorCodigo(2L);
		dao.excluir(funcionario);
	}
	
	//@Test
	/*void testExcluirPorCodigo() {
		FabricanteDAO dao = new FabricanteDAO();
		dao.excluirPorCodigo(3L);
		
	}*/
	
	@Test
	void testEditar() {
		Funcionario funcionario = new Funcionario();
		
		FuncionarioDAO dao = new FuncionarioDAO();
		
		funcionario = dao.buscaPorCodigo(4L);
		
		funcionario.setNome("B");
		
		dao.editar(funcionario);
	}

}
