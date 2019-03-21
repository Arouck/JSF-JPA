package br.progep.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.progep.dao.FabricanteDAO;
import br.progep.domain.Fabricante;
import br.progep.util.FacesUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FabricanteBean implements Serializable {
	
	private Fabricante fabricante;
	private List<Fabricante> fabricantes;
	private List<Fabricante> fabricantesFiltrados;
	
	public void salvar() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.salvar(fabricante);
			
			fabricante = new Fabricante();
			
			FacesUtil.addMsgInfo("Fabricante salvo com sucesso!");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.addMsgError("Ocorreu um erro ao tentar salvar o fabricante: " + ex.getMessage());
		}
		
		
	}
	
	public void limpar() {
		fabricante = new Fabricante();
	}
	
	public Fabricante getFabricante() {
		if(fabricante == null) {
			fabricante = new Fabricante();
		}
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
	
	public void carregar() {
		try {
			
			FabricanteDAO dao = new FabricanteDAO();
			
			fabricantes = dao.listar();
			
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.addMsgError("Ocorreu um erro ao tentar listar os fabricantes: " + ex.getMessage());
		}
	}

}
