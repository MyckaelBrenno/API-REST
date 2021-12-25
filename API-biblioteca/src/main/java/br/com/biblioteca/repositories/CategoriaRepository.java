package br.com.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.biblioteca.main.Categoria_livros;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria_livros, Integer>{

}
