package br.progep.teste;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.progep.dao.ItemDAO;
import br.progep.dao.ProdutoDAO;
import br.progep.dao.VendaDAO;
import br.progep.domain.Item;

class ItemDAOTest {

	// @Test
	void testSalvar() {

		ProdutoDAO daop = new ProdutoDAO();

		VendaDAO daov = new VendaDAO();

		Item item = new Item();

		item.setProduto(daop.buscaPorCodigo(3L));
		item.setVenda(daov.buscaPorCodigo(6L));
		item.setQuantidade(12);
		item.setValor(new BigDecimal(12.30D));

		ItemDAO dao = new ItemDAO();

		dao.salvar(item);
	}

	// @Test
	void testListar() {
		ItemDAO dao = new ItemDAO();
		List<Item> itens = dao.listar();

		for (Item item : itens) {
			System.out.println(item.toString());
		}

	}

	// @Test
	void testBuscarPorCodigo() {
		ItemDAO dao = new ItemDAO();
		Item p1 = dao.buscaPorCodigo(3L);

		System.out.println(p1.toString());
	}

	// @Test
	void testExcluir() {
		ItemDAO dao = new ItemDAO();
		dao.excluir(dao.buscaPorCodigo(5L));
	}

	@Test
	void testEditar() {
		ProdutoDAO daop = new ProdutoDAO();

		VendaDAO daov = new VendaDAO();

		ItemDAO dao = new ItemDAO();
		
		Item item = dao.buscaPorCodigo(3L);

		item.setProduto(daop.buscaPorCodigo(4L));
		item.setVenda(daov.buscaPorCodigo(3L));
		item.setQuantidade(13);
		item.setValor(new BigDecimal(12.31D));

		dao.editar(item);
	}

}
