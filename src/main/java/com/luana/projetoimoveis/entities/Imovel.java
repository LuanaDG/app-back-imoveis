package com.luana.projetoimoveis.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.luana.projetoimoveis.entities.enums.TipoImovel;
import com.luana.projetoimoveis.entities.enums.TipoMaterial;

@Entity
@Table(name = "imoveis")
public class Imovel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "tipo")
	@Enumerated(EnumType.STRING)
	private TipoImovel tipo;
	
	@Column(name = "material")
	@Enumerated(EnumType.STRING)
	private TipoMaterial material;
	
	@Column(name = "tamanho")
	private Double tamanho;
	
	@Column(name = "cidade")
	private String cidade;
	
	@Column(name = "data_construcao")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT" )
	private Date dataConstrucao;
	
	@Transient
	private Double valorTotal;

	public Imovel() {
	}

	public Imovel(Integer id, TipoImovel tipo, TipoMaterial material, Double tamanho, String cidade,
			Date dataConstrucao) {

		this.id = id;
		this.tipo = tipo;
		this.material = material;
		this.tamanho = tamanho;
		this.cidade = cidade;
		this.dataConstrucao = dataConstrucao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoImovel getTipo() {
		return tipo;
	}

	public void setTipo(TipoImovel tipo) {
		this.tipo = tipo;
	}

	@JsonProperty("descricaoTipo")
	public String descricaoTipoImovel(){
		if(this.tipo!=null){
			return this.tipo.getDescricao();
		}
		return null;
	}

	public TipoMaterial getMaterial() {
		return material;
	}

	public void setMaterial(TipoMaterial material) {
		this.material = material;
	}

	@JsonProperty("descricaoMaterial")
	public String descricaoMaterialImovel(){
		if(this.material!=null){
			return this.material.getDescricao();
		}
		return null;
	}

	public Double getTamanho() {
		return tamanho;
	}

	public void setTamanho(Double tamanho) {
		this.tamanho = tamanho;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Date getDataConstrucao() {
		return dataConstrucao;
	}

	public void setDataConstrucao(Date dataConstrucao) {
		this.dataConstrucao = dataConstrucao;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
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
		Imovel other = (Imovel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
