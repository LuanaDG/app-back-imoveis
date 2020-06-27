package com.luana.projetoimoveis.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.luana.projetoimoveis.entities.enums.TipoImovel;
import com.luana.projetoimoveis.entities.enums.TipoMaterial;

@Entity
@Table(name = "precos")
public class Preco implements Serializable{

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
	
	@Column(name = "preco_metro_quad")
	private Double precoMetroQuad;
	
	public Preco() {
	}

	public Preco(Integer id, TipoImovel tipo, TipoMaterial material, Double precoMetroQuad) {
		this.id = id;
		this.tipo = tipo;
		this.material = material;
		this.precoMetroQuad = precoMetroQuad;
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

	public TipoMaterial getMaterial() {
		return material;
	}

	public void setMaterial(TipoMaterial material) {
		this.material = material;
	}

	public Double getPrecoMetroQuad() {
		return precoMetroQuad;
	}

	public void setPrecoMetroQuad(Double precoMetroQuad) {
		this.precoMetroQuad = precoMetroQuad;
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
		Preco other = (Preco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
