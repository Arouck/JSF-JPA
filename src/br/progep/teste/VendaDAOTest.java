package br.progep.teste;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.progep.dao.FuncionarioDAO;
import br.progep.dao.VendaDAO;
import br.progep.domain.Venda;

class VendaDAOTest {

	@Test
	void testSalvar() {

		FuncionarioDAO daof = new FuncionarioDAO();
		
		Venda venda = new Venda();
		
		venda.setFuncionario(daof.buscaPorCodigo(1L));
		venda.setHorario(new Date());
		venda.setValor(new BigDecimal(8080.80D));
		
		VendaDAO dao = new VendaDAO();
		
		dao.salvar(venda);
	}

	//@Test
	void testListar() {
		VendaDAO dao = new VendaDAO();
		List<Venda> vendas = dao.listar();

		for (Venda venda : vendas) {
			System.out.println(venda.toString());
		}

	}

	//@Test
	void testBuscarPorCodigo() {
		VendaDAO dao = new VendaDAO();
		Venda p1 = dao.buscaPorCodigo(3L);

		System.out.println(p1.toString());
	}

	//@Test
	void testExcluir() {
		VendaDAO dao = new VendaDAO();
		dao.excluir(dao.buscaPorCodigo(5L));
	}
	
	//@Test
	void testEditar() {
		VendaDAO dao = new VendaDAO();
		FuncionarioDAO daof = new FuncionarioDAO();
		
		Venda p  = dao.buscaPorCodigo(3L);
		
		p.setFuncionario(daof.buscaPorCodigo(1L));
		p.setValor(new BigDecimal(23.06D));
		
		dao.editar(p);
	}

}
