package br.progep.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.progep.dao.ProdutoDAO;
import br.progep.domain.Item;
import br.progep.domain.Produto;
import br.progep.domain.Venda;
import br.progep.util.FacesUtil;

@ManagedBean
@ViewScoped
public class VendaBean {

	private List<Produto> produtos;
	private List<Produto> produtosFiltrados;
	private List<Item> itens;
	private Venda venda;

	public void carregarProdutos() {
		try {

			ProdutoDAO dao = new ProdutoDAO();

			produtos = dao.listar();

		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.addMsgError("Ocorreu um erro ao tentar listar os produtos! " + ex.getMessage());
		}
	}

	public void adicionar(Produto produto) {
		Integer position = 0;
		if (itens.size() > 0) {
			boolean found = false;
			
			do {
				if (itens.get(position).getProduto().equals(produto)) {
					itens.get(position).setQuantidade(itens.get(position).getQuantidade() + 1);
					itens.get(position).setValor(produto.getPreco().multiply(new BigDecimal(itens.get(position).getQuantidade())));
					found = true;
				} else {
					position++;
				}
			} while (position < itens.size() && found == false);
			
			if(found == false) {
				Item item = new Item();
				item.setProduto(produto);
				item.setQuantidade(1);
				item.setValor(produto.getPreco());

				itens.add(item);
			}
		} else {

			Item item = new Item();
			item.setProduto(produto);
			item.setQuantidade(1);
			item.setValor(produto.getPreco());

			itens.add(item);
		}
		
		venda.setValor(venda.getValor().add(produto.getPreco()));
	}
	
	public void remover(Item item) {
		int position = 0;
		do {
			if (itens.get(position).getProduto().equals(item.getProduto())) {
				venda.setValor(venda.getValor().subtract(itens.get(position).getValor()));
				itens.remove(position);
			} else {
				position++;
			}
		} while (position < itens.size());
		
		
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}

	public void setProdutosFiltrados(List<Produto> produtosFiltrados) {
		this.produtosFiltrados = produtosFiltrados;
	}

	public List<Item> getItens() {
		if (itens == null) {
			itens = new ArrayList<>();
		}
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public Venda getVenda() {
		if(venda == null) {
			venda = new Venda();
			venda.setValor(new BigDecimal("0.00"));
		}
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}
}
