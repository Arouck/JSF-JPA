package br.progep.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "tbl_fabricantes")
public class Fabricante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fab_codigo")
	private Long codigo;
	
	@Column(length = 50, nullable = false, name = "fab_descricao")
	@NotBlank(message = "A descrição do Fabricante não pode ficar em branco!")
	@Length(max = 50, message = "A descrição do Fabricante não pode ter mais que {max} caracteres!")
	private String descricao;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Fabricante [codigo = " + codigo + ", descricao = " + descricao + "]";
	}
}
