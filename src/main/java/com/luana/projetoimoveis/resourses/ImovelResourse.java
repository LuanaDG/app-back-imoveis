package com.luana.projetoimoveis.resourses;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "/imoveis")
public class ImovelResourse {
	
	@GetMapping
	public ResponseEntity<String> findAll(){
//		List<User> list = service.findAll();
		
		return ResponseEntity.ok().body("Funcionando");
	}

}
