package br.progep.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.progep.dao.FabricanteDAO;
import br.progep.domain.Fabricante;
import br.progep.util.FacesUtil;

@ManagedBean
@ViewScoped
public class FabricanteBean {
	
	private Fabricante fabricante;
	private List<Fabricante> fabricantes;
	private List<Fabricante> fabricantesFiltrados;
	private String acao;
	private Long codigo;
	
	public void salvar() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.salvar(fabricante);
			
			fabricante = new Fabricante();
			
			FacesUtil.addMsgInfo("Fabricante cadastrado com sucesso!");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.addMsgError("Não foi possível cadastrar o fabricante: " + 
					ex.getMessage());
		}
	}
	
	public void limpar() {
		fabricante = new Fabricante();
	}
	
	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	public List<Fabricante> getFabricantesFiltrados() {
		return fabricantesFiltrados;
	}

	public void setFabricantesFiltrados(List<Fabricante> fabricantesFiltrados) {
		this.fabricantesFiltrados = fabricantesFiltrados;
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

	public void carregarPesquisa() {
		try {
			
			FabricanteDAO dao = new FabricanteDAO();
			
			fabricantes = dao.listar();
			
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.addMsgError("Ocorreu um erro ao tentar listar os fabricantes: " + ex.getMessage());
		}
	}
	
	public void carregarCadastro() {
		try {
			if(codigo != null) {
				FabricanteDAO dao = new FabricanteDAO();
				
				fabricante = dao.buscaPorCodigo(codigo);
			} else {
				fabricante = new Fabricante();
			}
			
		} catch (Exception ex) {
			FacesUtil.addMsgError("Erro ao tentar obter os dados do Fabricante: "
					+ ex.getMessage());
		}
	}
	
	public void excluir() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.excluir(fabricante);
			
			FacesUtil.addMsgInfo("Fabricante removido com sucesso!");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.addMsgError("Ocorreu um erro ao tentar remover o fabricante: " + ex.getMessage());
		}
	}
	
	
	public void editar() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.editar(fabricante);
			
			FacesUtil.addMsgInfo("Fabricante editado com sucesso!");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.addMsgError("Ocorreu um erro ao tentar editar o fabricante: " + ex.getMessage());
		}
		
		
	}
}
