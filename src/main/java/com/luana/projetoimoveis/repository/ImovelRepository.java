package com.luana.projetoimoveis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.luana.projetoimoveis.entities.Imovel;


public interface ImovelRepository extends JpaRepository<Imovel, Integer>{
	
	@Query(value = "SELECT * FROM imoveis i WHERE NOT EXISTS( SELECT 1 FROM vendas v WHERE v.id_imovel = i.id )", nativeQuery = true)
	List<Imovel> listaImoveisDisponiveis();

}
