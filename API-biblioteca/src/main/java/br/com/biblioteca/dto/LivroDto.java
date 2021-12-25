package br.com.biblioteca.dto;

import java.io.Serializable;

import br.com.biblioteca.main.Livros;

public class LivroDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String titulo;
	
	public LivroDto() {
		super();
	}

	public LivroDto(Livros obj) {
		super();
		this.id = obj.getId();
		this.titulo = obj.getTitulo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
}
