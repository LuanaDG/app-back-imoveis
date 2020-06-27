package com.luana.projetoimoveis.entities.enums;

public enum TipoMaterial {

	ALVENARIA(1,"Alvenaria"),
	MADEIRA(2,"Madeira"), 
	MISTA(3,"Mista");

	
	private final Integer codigo;
	private final String descricao;
	
	TipoMaterial(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoMaterial getByCodigo(Integer codigo) {
	    
		for(TipoMaterial item : values()) {
	        if(item.codigo.equals(codigo)) {
	        	return item;
	        }
	    }
	    return null;
	}
}
