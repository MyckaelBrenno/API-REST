package br.com.biblioteca.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.biblioteca.main.Livros;
import br.com.biblioteca.main.StatusLivro;

@Repository
public interface LivroRepository extends JpaRepository<Livros, Integer>{

	@Query("SELECT obj FROM Livros obj WHERE obj.categoria.id = :id_cat ORDER BY titulo")
	List<Livros> findAllByCategoria(@Param(value = "id_cat") Integer id_cat);
	
	@Query("SELECT obj FROM Livros obj WHERE obj.statusLivro.id = :id_livro ORDER BY titulo")
	List<Livros> findByStatusLivro(@Param(value="id_livro") Integer id_livro);

}
