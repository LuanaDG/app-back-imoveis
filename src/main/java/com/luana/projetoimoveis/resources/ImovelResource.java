package com.luana.projetoimoveis.resources;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.luana.projetoimoveis.entities.Imovel;
import com.luana.projetoimoveis.service.ImovelService;



@RestController
@RequestMapping(value = "/imoveis")
public class ImovelResource {
	
	@Autowired
	private ImovelService service;
	
	@GetMapping
	public ResponseEntity<List<Imovel>> findAll(){
		List<Imovel> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Imovel> findById(@PathVariable Integer id){
		Imovel obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Imovel> insert(@RequestBody Imovel obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Imovel>update(@PathVariable Integer id, @RequestBody Imovel obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/imoveisdisponiveis")
	public ResponseEntity<List<Imovel>> findImoveisDisponiveis(){
		List<Imovel> obj = service.listaImoveisDisponiveis();
		return ResponseEntity.ok().body(obj);
	}
	
	
}
