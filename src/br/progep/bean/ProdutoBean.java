package br.progep.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.progep.dao.FabricanteDAO;
import br.progep.dao.ProdutoDAO;
import br.progep.domain.Fabricante;
import br.progep.domain.Produto;
import br.progep.util.FacesUtil;

@ManagedBean
@ViewScoped
public class ProdutoBean {
	
	Produto produto;
	private List<Produto> produtos;
	private List<Produto> produtosFiltrados;
	private String acao;
	private Long codigo;
	private List<Fabricante> fabricantes;
	
	public void salvar() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			
			dao.salvar(produto);
			
			produto = new Produto();
			
			FacesUtil.addMsgInfo("Produto cadastrado com sucesso!");
			
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.addMsgError("Não foi possível cadastrar do produto! " +
					ex.getMessage());
		}
	}
	
	public void carregarPesquisa() {
		try {
			
			ProdutoDAO dao = new ProdutoDAO();
			
			produtos = dao.listar();
			
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.addMsgError("Ocorreu um erro ao tentar listar os produtos! " + ex.getMessage());
		}
	}
	
	public void carregarCadastro() {
		try {
			if(codigo != null) {
				ProdutoDAO dao = new ProdutoDAO();
				
				produto = dao.buscaPorCodigo(codigo);
			} else {
				produto = new Produto();
			}
			
			FabricanteDAO daof = new FabricanteDAO();
			fabricantes = daof.listar();
			
		} catch (Exception ex) {
			FacesUtil.addMsgError("Erro ao tentar obter os dados do produto: "
					+ ex.getMessage());
		}
	}
	
	public void excluir() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.excluir(produto);
			
			FacesUtil.addMsgInfo("Produto removido com sucesso!");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.addMsgError("Ocorreu um erro ao tentar remover o produto! " + ex.getMessage());
		}
	}
	
	public void editar() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.editar(produto);
			
			FacesUtil.addMsgInfo("Produto editado com sucesso!");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.addMsgError("Ocorreu um erro ao tentar editar o produto: " + ex.getMessage());
		}
	}
	
	public void limpar() {
		produto = new Produto();
	}

	public Produto getProduto() {
		if(produto == null) {
			produto = new Produto();
		}
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
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

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

}
