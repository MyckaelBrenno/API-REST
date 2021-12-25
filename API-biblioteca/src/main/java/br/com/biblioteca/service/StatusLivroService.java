package br.com.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.biblioteca.main.Livros;
import br.com.biblioteca.main.StatusLivro;
import br.com.biblioteca.repositories.StatusLivroRepository;
import br.com.biblioteca.service.execption.ObjectNotFoundException;

@Service
public class StatusLivroService {
	
	@Autowired
	StatusLivroRepository repository;
	
	//@Autowired
	//LivroService livroService;
	
	public StatusLivro findById(Integer id) {
	Optional<StatusLivro> obj = repository.findById(id);
	return obj.orElseThrow(() -> new ObjectNotFoundException(
			"Objeto não encontrado! Id: " + id + ", Tipo: " + Livros.class.getName()));
	}
	
	public List<StatusLivro> findAll() {
		return repository.findAll();
	}
	
	public StatusLivro create(StatusLivro obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public StatusLivro update(Integer id, StatusLivro obj) {
		StatusLivro newObj = findById(id);
		newObj.setStatus(obj.getStatus());
		return repository.save(obj);
	}

}
