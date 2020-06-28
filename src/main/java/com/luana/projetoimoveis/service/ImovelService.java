package com.luana.projetoimoveis.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import com.luana.projetoimoveis.entities.Imovel;
import com.luana.projetoimoveis.exception.BusinessException;
import com.luana.projetoimoveis.exception.DataBaseException;
import com.luana.projetoimoveis.exception.ResourceNotFoundException;
import com.luana.projetoimoveis.repository.ImovelRepository;

@Service
public class ImovelService {

	@Autowired
	private ImovelRepository repository;
	
	public List<Imovel> findAll(){
		return repository.findAll();
	}
	
	public Imovel findById(Integer id) {
		Optional<Imovel> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Imovel insert(Imovel obj) {
		
		executaValidacoes(obj);
		
		return repository.save(obj);
	}

	private void executaValidacoes(Imovel obj) {
		if(obj.getDataConstrucao().after(new Date())) {
			throw new BusinessException("A data da construção não pode ser superior a data atual.");
		}
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
	
	public Imovel update(Integer id, Imovel obj) {
		try {
			
			if(!repository.existsById(id)) {
				throw new ResourceNotFoundException("O imóvel com o ID:"+id+ " não existe.");
			}
			obj.setId(id);
			
			executaValidacoes(obj);
			
			return repository.save(obj);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
}
