package br.com.biblioteca.main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Campo NOME é obrigatório")
	@Length(min = 3, max = 100, message = "O campo NOME deve ter entre 3 e 100 Caracteres")
	private String nome;
	
	@NotEmpty(message = "Campo RUA é obrigatório")
	@Length(min = 3, max = 100, message = "O campo RUA deve ter entre 3 e 100 Caracteres")
	private String rua;
	
	@NotEmpty(message = "Campo BAIRRO é obrigatório")
	@Length(min = 3, max = 100, message = "O campo BAIRRO deve ter entre 3 e 100 Caracteres")
	private String bairro;
	
	@NotEmpty(message = "Campo CIDADE é obrigatório")
	@Length(min = 3, max = 100, message = "O campo CIDADE deve ter entre 3 e 100 Caracteres")
	private String cidade;
	
	@NotEmpty(message = "Campo UF é obrigatório")
	@Length(min = 2, max = 2, message = "O campo UF deve ter 2 Caracteres")
	private String uf;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "categoria_cliente_id")
	private Categoria_livros categoria;
	
	@JsonIgnore
	@ManyToMany
	@JoinColumn(name = "livros_cliente_id")
	private List<Livros> livros = new ArrayList<>();
	
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(Integer id, String nome, String rua, String bairro, String cidade, String uf, Categoria_livros categoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.categoria = categoria;
	}
	public Categoria_livros getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria_livros categoria) {
		this.categoria = categoria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public List<Livros> getLivros() {
		return livros;
	}

	public void setLivros(List<Livros> livros) {
		this.livros = livros;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
