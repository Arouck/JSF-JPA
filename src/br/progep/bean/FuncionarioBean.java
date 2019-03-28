package br.progep.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.progep.dao.FuncionarioDAO;
import br.progep.domain.Funcionario;
import br.progep.util.FacesUtil;

@ManagedBean
@ViewScoped
public class FuncionarioBean {
	
	Funcionario funcionario;
	private List<Funcionario> funcionarios;
	private List<Funcionario> funcionariosFiltrados;
	private String acao;
	private Long codigo;
	
	public void salvar() {
		try {
			FuncionarioDAO dao = new FuncionarioDAO();
			
			dao.salvar(funcionario);
			
			funcionario = new Funcionario();
			
			FacesUtil.addMsgInfo("Funcion�rio cadastrado com sucesso!");
			
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.addMsgError("N�o foi poss�vel cadastrar do funcion�rio! " +
					ex.getMessage());
		}
	}
	
	public void carregarPesquisa() {
		try {
			
			FuncionarioDAO dao = new FuncionarioDAO();
			
			funcionarios = dao.listar();
			
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.addMsgError("Ocorreu um erro ao tentar listar os funcion�rios! " + ex.getMessage());
		}
	}
	
	public void carregarCadastro() {
		try {
			if(codigo != null) {
				FuncionarioDAO dao = new FuncionarioDAO();
				
				funcionario = dao.buscaPorCodigo(codigo);
			} else {
				funcionario = new Funcionario();
			}
			
		} catch (Exception ex) {
			FacesUtil.addMsgError("Erro ao tentar obter os dados do funcion�rio: "
					+ ex.getMessage());
		}
	}
	
	public void excluir() {
		try {
			FuncionarioDAO dao = new FuncionarioDAO();
			dao.excluir(funcionario);
			
			FacesUtil.addMsgInfo("Funcion�rio removido com sucesso!");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.addMsgError("Ocorreu um erro ao tentar remover o funcion�rio! " + ex.getMessage());
		}
	}
	
	public void editar() {
		try {
			FuncionarioDAO dao = new FuncionarioDAO();
			dao.editar(funcionario);
			
			FacesUtil.addMsgInfo("Funcion�rio editado com sucesso!");
		} catch (RuntimeException ex) {
			ex.printStackTrace();
			FacesUtil.addMsgError("Ocorreu um erro ao tentar editar o funcion�rio: " + ex.getMessage());
		}
	}
	
	public void limpar() {
		funcionario = new Funcionario();
	}

	public Funcionario getFuncionario() {
		if(funcionario == null) {
			funcionario = new Funcionario();
		}
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public List<Funcionario> getFuncionariosFiltrados() {
		return funcionariosFiltrados;
	}

	public void setFuncionariosFiltrados(List<Funcionario> funcionariosFiltrados) {
		this.funcionariosFiltrados = funcionariosFiltrados;
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

}
