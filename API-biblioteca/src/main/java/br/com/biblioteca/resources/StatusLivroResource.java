package br.com.biblioteca.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.biblioteca.main.StatusLivro;
import br.com.biblioteca.service.StatusLivroService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/status")
public class StatusLivroResource {
	
	@Autowired
	StatusLivroService service;
	
	//****GET EM TODOS STATUS POR ID****
	@GetMapping(value = "/{id}")
	public ResponseEntity <StatusLivro> findById(@PathVariable Integer id) {
		StatusLivro obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		// http://localhost:8080/status/2
	}
	
	//****POST UM NOVO STATUS****
	@PostMapping
	public ResponseEntity<StatusLivro> create(@Valid @RequestBody StatusLivro obj){
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		// http://localhost:8080/status
	}

		//***ALTERA O VALOR DO STATUS***
		@PatchMapping(value = "/{id}")
		public ResponseEntity<StatusLivro> updatePatch(@PathVariable Integer id, @Valid @RequestBody StatusLivro obj) {
			StatusLivro newObj = service.update(id, obj);
			return ResponseEntity.ok().body(newObj);
			// http://localhost:8080/status/2
		}
		
		//****ATUALIZA O STATUS DO LIVRO****
		@PutMapping
		public ResponseEntity<StatusLivro> updatePatchLivrosStatus(@RequestParam(value = "livros", defaultValue = "0") Integer id_status,
		@Valid @RequestBody StatusLivro obj) {
			StatusLivro newObj = service.update(id_status, obj);
			URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/status/{id}")
					.buildAndExpand(newObj.getId()).toUri();
			return ResponseEntity.ok().body(newObj);
			// http://localhost:8080/status?livros=1
		}
	

}
