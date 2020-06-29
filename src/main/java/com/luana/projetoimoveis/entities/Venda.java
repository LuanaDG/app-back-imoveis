package com.luana.projetoimoveis.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "vendas")
public class Venda implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "cpf_cliente")
	private String cpf;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "data_venda")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT" )
	private Date dataVenda;
	
	@Column(name = "id_imovel")
	private Integer idImovel;
	
	@OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_imovel", referencedColumnName = "id", insertable = false, updatable = false)
    private Imovel imovel;
	
	@Column(name = "valor_total")
	private Double valorTotal;
	
	
	public Venda() {
	}
	
	public Venda(Integer id, String cpf, String nome, Date dataVenda, Integer idImovel, Double valorTotal) {
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.dataVenda = dataVenda;
		this.idImovel = idImovel;
		this.valorTotal = valorTotal;
	}

	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public String getCpf() {
		return cpf;
	}




	public void setCpf(String cpf) {
		this.cpf = cpf;
	}




	public String getNome() {
		return nome;
	}




	public void setNome(String nome) {
		this.nome = nome;
	}




	public Date getDataVenda() {
		return dataVenda;
	}




	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}




	public Integer getIdImovel() {
		return idImovel;
	}




	public void setIdImovel(Integer idImovel) {
		this.idImovel = idImovel;
	}




	public Double getValorTotal() {
		return valorTotal;
	}




	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Venda other = (Venda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
