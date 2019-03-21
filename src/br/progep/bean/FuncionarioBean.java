package br.progep.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.progep.domain.Funcionario;
import br.progep.util.FacesUtil;

@ManagedBean
@ViewScoped
public class FuncionarioBean {
	
	Funcionario funcionario;
	
	public void salvar() {
		FacesUtil.addMsgInfo("Funcionario salvo com sucesso!");
		FacesUtil.addMsgInfo(funcionario.toString());
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

}
