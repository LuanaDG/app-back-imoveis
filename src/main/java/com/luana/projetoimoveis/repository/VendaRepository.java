package com.luana.projetoimoveis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.luana.projetoimoveis.entities.Venda;

public interface VendaRepository extends JpaRepository<Venda, Integer> {

	@Query(value = " SELECT * FROM vendas v WHERE MONTH(v.data_venda) = :mes AND YEAR(v.data_venda) = :ano " ,nativeQuery = true)
	List<Venda> listaVendasPorMesEAno(@Param("mes") Integer mes,@Param("ano") Integer ano);
	
	@Query(value = " SELECT case when COUNT(v.id) > 0 then 'true' else 'false' end FROM vendas v WHERE v.id_imovel = :idImovel " ,nativeQuery = true)
	Boolean imovelJaFoiVendido(@Param("idImovel") Integer idImovel);
	
}
