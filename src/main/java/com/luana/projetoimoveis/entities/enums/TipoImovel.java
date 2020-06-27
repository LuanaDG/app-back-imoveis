package com.luana.projetoimoveis.entities.enums;

public enum TipoImovel {
	
	CASA(1, "Casa"),
	PREDIO(2, "Prédio"),
	SALA_COMERCIAL(3, "Sala Comercial"),
	PAVILHAO(4, "Pavilhão");
	
	private final Integer codigo;
	private final String descricao;
	
	private TipoImovel(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
public static TipoImovel getByCodigo(Integer codigo) {
	    
		for(TipoImovel item : values()) {
	        if(item.codigo.equals(codigo)) {
	        	return item;
	        }
	    }
	    return null;
	}
}

