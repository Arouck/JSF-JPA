package br.progep.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@SuppressWarnings("serial")
@Entity
@Table(name = "tbl_produtos")
public class Produto implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pro_codigo")
	private Long codigo;
	
	@Column(name = "pro_descricao", length = 50, nullable = false)
	@Length(max = 50, message = "A descri��o do Produto n�o pode ter mais que {max} carateres!")
	@NotBlank(message = "A descri��o do Produto n�o pode ficar em branco!")
	private String descricao;
	
	@NotNull(message = "O pre�o � obrigat�rio!")
	@DecimalMin(value = "0.00", message = "O pre�o n�o pode ser menor que {value}!")
	@Column(name = "pro_peco", precision = 7, scale = 2, nullable = false)
	private BigDecimal preco;
	
	@NotNull(message = "A quantidade � obrigat�ria!")
	@Min(value = 0, message = "A quantidade n�o pode ser menor que {value}!")
	@Column(name = "pro_quantidade", nullable = false)
	private Integer quantidade;
	
	@NotNull(message = "O fabricante � obrigat�rio!")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "tbl_fabricantes_fab_codigo", referencedColumnName = "fab_codigo",
				foreignKey = @ForeignKey(name = "fk_fabricante"))
	private Fabricante fabricante;

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

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	@Override
	public String toString() {
		return "Produto [codigo = " + codigo + ", descricao = " + descricao + ", preco = " + preco + ", quantidade = "
				+ quantidade + ", fabricante = " + fabricante + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
