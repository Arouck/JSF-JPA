package br.progep.teste;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.progep.dao.FabricanteDAO;
import br.progep.dao.ProdutoDAO;
import br.progep.domain.Fabricante;
import br.progep.domain.Produto;

class ProdutoDAOTest {

	// @Test
	void testSalvar() {

		FabricanteDAO fdao = new FabricanteDAO();

		Fabricante f = fdao.buscaPorCodigo(11L);

		Produto p = new Produto();

		p.setDescricao("P");
		p.setPreco(new BigDecimal(23.55D));
		p.setQuantidade(100);
		p.setFabricante(f);

		ProdutoDAO dao = new ProdutoDAO();

		dao.salvar(p);
	}

	// @Test
	void testListar() {
		ProdutoDAO dao = new ProdutoDAO();
		List<Produto> produtos = dao.listar();

		for (Produto produto : produtos) {
			System.out.println(produto.toString());
		}

	}

	// @Test
	void testBuscarPorCodigo() {
		ProdutoDAO dao = new ProdutoDAO();
		Produto p1 = dao.buscaPorCodigo(4L);

		System.out.println(p1.toString());
	}

	//@Test
	void testExcluir() {
		ProdutoDAO dao = new ProdutoDAO();
		Produto p1 = dao.buscaPorCodigo(6L);
		dao.excluir(p1);
	}
	
	@Test
	void testEditar() {
		ProdutoDAO dao = new ProdutoDAO();
		
		Produto p = dao.buscaPorCodigo(3L);
		
		FabricanteDAO daof = new FabricanteDAO();
		
		p.setDescricao("E");
		p.setFabricante(daof.buscaPorCodigo(8L));
		p.setPreco(new BigDecimal(98.35D));
		
		dao.editar(p);
	}

}
