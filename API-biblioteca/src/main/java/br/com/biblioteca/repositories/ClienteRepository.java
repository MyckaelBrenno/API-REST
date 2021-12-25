package br.com.biblioteca.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.biblioteca.main.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	@Query("SELECT obj FROM Cliente obj WHERE obj.categoria.id = :id_cat ORDER BY nome")
	List<Cliente> findAllByCategoria(@Param(value = "id_cat") Integer id_cat);

}
