package br.com.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.biblioteca.main.Categoria_livros;
import br.com.biblioteca.main.Cliente;
import br.com.biblioteca.main.Livros;
import br.com.biblioteca.main.StatusLivro;
import br.com.biblioteca.repositories.LivroRepository;
import br.com.biblioteca.service.execption.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;
	
	//@Autowired
	//private CategoriaService categoriaService;
	
	@Autowired
	private StatusLivroService statusLivroService;

	public Livros findById(Integer id) {
		Optional<Livros> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Livros.class.getName()));
	}
	
	public List<Livros> findAllLivro(){
		return repository.findAll();
	}
	
	public List<Livros> findStatus(Integer id_status) {
		statusLivroService.findById(id_status);
		return repository.findByStatusLivro(id_status);
	}

	/*
	public List<Livros> findAllByCategoria(Integer id_cat) {
		categoriaService.findById(id_cat);
		return repository.findAllByCategoria(id_cat);
	}
	 */
	public Livros update(Integer id, Livros obj) {
		Livros newObj = findById(id);
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	private void updateData(Livros newObj, Livros obj) {
		newObj.setTitulo(obj.getTitulo());
		newObj.setAutor(obj.getAutor());
		newObj.setTexto(obj.getTexto());
	}
	
	/*public Livros createCat(Integer id_cat, Livros obj) {
		obj.setId(null);
		Categoria_livros cat = categoriaService.findById(id_cat);
		obj.setCategoria(cat);
		return repository.save(obj);
	}
	*/
	
	public Livros create(Integer id_livros, Livros obj) {
		obj.setId(null);
		StatusLivro statusLivro = statusLivroService.findById(id_livros);
		obj.setStatusLivro(statusLivro);
		return repository.save(obj);
	}
	

	public void delete(Integer id) {
		Livros obj = findById(id);
		repository.delete(obj);
		
	}

}
