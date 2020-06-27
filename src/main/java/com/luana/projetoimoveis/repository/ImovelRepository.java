package com.luana.projetoimoveis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luana.projetoimoveis.entities.Imovel;


public interface ImovelRepository extends JpaRepository<Imovel, Integer>{

}
