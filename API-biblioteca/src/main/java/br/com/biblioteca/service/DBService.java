package br.com.biblioteca.service;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.biblioteca.main.Categoria_livros;
import br.com.biblioteca.main.Cliente;
import br.com.biblioteca.main.Livros;
import br.com.biblioteca.main.StatusLivro;
import br.com.biblioteca.repositories.CategoriaRepository;
import br.com.biblioteca.repositories.ClienteRepository;
import br.com.biblioteca.repositories.LivroRepository;
import br.com.biblioteca.repositories.StatusLivroRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private StatusLivroRepository statusLivroRepository;

	public void instanciaDB() {
		
		Categoria_livros cat1 = new Categoria_livros(null, "Informática", "Ficção");
		
		Categoria_livros cat2 = new Categoria_livros(null, "Romance", "Amor");
		
		Categoria_livros cat3 = new Categoria_livros(null, "Comédia", "Muitas Gargalhadas");
		
		//Clientes e Livros da Categoria Romance
		Cliente c1 = new Cliente(null, "Myckael", "Euclides Ferreira de Carvalho", "Jardim Cidade Universitária", "João Pessoa", "PB", cat2);
		Cliente c2 = new Cliente(null, "Ana", "Bom Tempo", "Centro", "Goiana", "PE", cat2);
		Cliente c3 = new Cliente(null, "Luna", "Avenida Nunes Machado", "Centro", "Goiana", "PE", cat2);
		Cliente c4 = new Cliente(null, "Rhuan", "Rua dos Martírios", "Centro", "Goiana", "PE", cat2);
		
		StatusLivro s1 = new StatusLivro(null, 1);
		StatusLivro s2 = new StatusLivro(null, 2);
		StatusLivro s3 = new StatusLivro(null, 3);
		
		Livros l1 = new Livros(null, "Amor e Gelato", "Jenna Evans", "Um verão na Itália, uma antiga história de amor e um segredo de família", cat2, s1);
		Livros l2 = new Livros(null, "A culpa é da Estrelas", "John Green", "Romance, Ficção juvenil, Romance de amor", cat2, s2);
		Livros l3 = new Livros(null, "Dom Casmurro", "Machado de Assis", "Escrito para publicação em livro, o que ocorreu em 1900", cat2, s2);
		
		
		cat2.getLivros().addAll(Arrays.asList(l1, l2, l3));
		cat2.getCliente().addAll(Arrays.asList(c1, c2, c3, c4));
		s1.getLivros().add(l1);
		s1.getLivros().add(l3);
		s2.getLivros().add(l2);
		
		
		
		//Clientes e Livros da Categoria Informática
		Cliente c5 = new Cliente(null, "Ana", "Bom Tempo", "Centro", "Goiana", "PE", cat1);
		Cliente c6 = new Cliente(null, "Luna", "Avenida Nunes Machado", "Centro", "Goiana", "PE", cat1);
		
		Livros l4 = new Livros(null, "Os Inovadores - Uma Biografia da Revolução Digital", "Walter", "Uma Biografia da Revolução Digital é um livro lançado em 2014, escrito por Walter Isaacson.", cat1, s1);
		Livros l5 = new Livros(null, "Elon Musk: Tesla, SpaceX, and the Quest for a Fantastic Future", "Ashlee Vance", "Elon Musk: Como o CEO bilionário da SpaceX e da Tesla está moldando o nosso futuro, é a biografia de Elon Musk escrita por Ashlee Vance", cat1, s1);
		
		cat1.getLivros().addAll(Arrays.asList(l4, l5));
		cat1.getCliente().addAll(Arrays.asList(c5, c6));
		s3.getLivros().add(l5);
		s2.getLivros().add(l4);
		
		
		//Clientes e Livros da Categoria Comédia
		Cliente c7 = new Cliente(null, "Myckael", "Euclides Ferreira de Carvalho", "Jardim Cidade Universitária", "João Pessoa", "PB", cat3);
		
		Livros l6 = new Livros(null, "Paraíso", "Dante Alighieri", "A Divina Comédia é um poema de viés épico e teológico da literatura italiana e mundial", cat3, s3);
		Livros l7 = new Livros(null, "Cadê você, Bernadette?", "Maria Sample", "Romance, Humor, Ficção humorística, Ficção Doméstica", cat3, s2);
		Livros l8 = new Livros(null, "Holy Cow: Uma fábula animal", "David Duchovny", "Uma aventura irreverente criada pelo astro de Arquivo X com muita personalidade e uma heroína quadrúpede inesquecível.", cat3, s1);
		
		cat3.getLivros().addAll(Arrays.asList(l6, l7, l8));
		cat3.getCliente().addAll(Arrays.asList(c7));
		s1.getLivros().add(l7);
		s2.getLivros().add(l8);
		s3.getLivros().add(l6);
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5, l6, l7, l8));
		this.clienteRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7));
		this.statusLivroRepository.save(s1);
		this.statusLivroRepository.save(s2);
		this.statusLivroRepository.save(s3);
		
	}

}
