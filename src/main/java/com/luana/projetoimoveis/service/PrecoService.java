package com.luana.projetoimoveis.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.luana.projetoimoveis.entities.Preco;
import com.luana.projetoimoveis.exception.DataBaseException;
import com.luana.projetoimoveis.exception.ResourceNotFoundException;
import com.luana.projetoimoveis.repository.PrecoRepository;

@Service
public class PrecoService {

	@Autowired
	private PrecoRepository repository;
	
	public List<Preco> findAll(){
		return repository.findAll();
	}
	
	public Preco findById(Integer id) {
		Optional<Preco> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Preco insert(Preco obj) {
		return repository.save(obj);
	}
	
	public void delete(Integer id) {
		try {
		repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
		}
		
		public Preco update(Integer id, Preco obj) {
			try {
				
				if(!repository.existsById(id)) {
					throw new ResourceNotFoundException("O imóvel com o ID:"+id+ " não existe.");
				}
				obj.setId(id);
				
				return repository.save(obj);
			}catch (EntityNotFoundException e) {
				throw new ResourceNotFoundException(id);
			}
	}
}
