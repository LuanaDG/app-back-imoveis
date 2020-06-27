package com.luana.projetoimoveis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.luana.projetoimoveis.entities.Preco;
import com.luana.projetoimoveis.entities.enums.TipoImovel;
import com.luana.projetoimoveis.entities.enums.TipoMaterial;

public interface PrecoRepository extends JpaRepository<Preco, Integer>{
	
	
	@Query("SELECT p FROM Preco p WHERE p.tipo = ?1 AND p.material = ?2 ")
	Preco buscaPrecoPorTipoImovelETipoMaterial(TipoImovel tipo, TipoMaterial tipoMaterial);

}
