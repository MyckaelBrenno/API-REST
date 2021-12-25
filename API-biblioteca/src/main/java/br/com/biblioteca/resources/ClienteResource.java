package br.com.biblioteca.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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

import br.com.biblioteca.dto.ClienteDto;
import br.com.biblioteca.main.Cliente;
import br.com.biblioteca.main.Livros;
import br.com.biblioteca.service.ClienteService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/cliente")
public class ClienteResource {
	
	@Autowired
	private ClienteService service;

	//****GET POR ID CLIENTE****
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Integer id){
		Cliente obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		// http://localhost:8080/cliente/1
	}
	
	//****GET DE CLIENTE POR CATEGORIA DE LIVROS****
	@GetMapping
	public ResponseEntity<List<ClienteDto>> findAll(@RequestParam (value = "categoria", defaultValue = "0") Integer id_cat){
		List<Cliente> list = service.findAll(id_cat);
		List<ClienteDto> listDTO = list.stream().map(obj -> new ClienteDto(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
		// http://localhost:8080/cliente?categoria=1
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Cliente> update(@PathVariable Integer id, @Valid @RequestBody Cliente obj) {
		Cliente newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@PatchMapping(value = "/{id}")
	public ResponseEntity<Cliente> updatePacth(@PathVariable Integer id, @Valid @RequestBody Cliente obj) {
		Cliente newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	//****POST DE CLIENTE POR CATEGORIA****
	@PostMapping
	public ResponseEntity<Cliente> create(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat,
			@Valid @RequestBody Cliente obj) {
		Cliente newObj = service.create(id_cat, obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/cliente/{id}")
				.buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		// http://localhost:8080/cliente?categoria=3
	}
	
	//****DELETE DE CLIENTE POR ID****
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
		// http://localhost:8080/cliente/1
	}
	
}
