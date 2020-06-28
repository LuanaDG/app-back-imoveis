package com.luana.projetoimoveis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.luana.projetoimoveis.entities.Preco;
import com.luana.projetoimoveis.entities.enums.TipoImovel;
import com.luana.projetoimoveis.entities.enums.TipoMaterial;

public interface PrecoRepository extends JpaRepository<Preco, Integer>{
	
	
	@Query("SELECT p FROM Preco p WHERE p.tipo = :tipo AND p.material = :material ")
	Preco buscaPrecoPorTipoImovelETipoMaterial(@Param("tipo") TipoImovel tipo, @Param("material") TipoMaterial tipoMaterial);
	
}
