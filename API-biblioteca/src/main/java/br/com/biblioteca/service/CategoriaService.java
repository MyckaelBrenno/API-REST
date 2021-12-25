package br.com.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.biblioteca.dto.CategoriaDto;
import br.com.biblioteca.main.Categoria_livros;
import br.com.biblioteca.repositories.CategoriaRepository;
import br.com.biblioteca.service.execption.DataIntegrityViolationException;
import br.com.biblioteca.service.execption.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public Categoria_livros findById(Integer id) {

		Optional<Categoria_livros> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", Tipo: " + Categoria_livros.class.getName()));
	}
	
	public List<Categoria_livros> findAll(){
		return repository.findAll();
	}
	
	public Categoria_livros create(Categoria_livros obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Categoria_livros update(Integer id, CategoriaDto objDto) {
		Categoria_livros obj = findById(id);
		obj.setNome(objDto.getNome());
		obj.setInfo(objDto.getInfo());
		return repository.save(obj);
	}

	public void delete(Integer id) {
		findById(id);
		
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Categoria não pode ser deletada! Possui livros associados");
		}
	}
}
