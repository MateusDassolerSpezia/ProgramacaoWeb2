package application.controller;

import application.model.Loja;
import application.service.LojaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/lojas")
public class LojaController {

	private final LojaService service;

	public LojaController(LojaService service) {
		this.service = service;
	}

	@GetMapping
	public List<Loja> listar() {
		return service.listar();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Loja> buscar(@PathVariable Integer id) {
		try {
			Loja loja = service.buscarPorId(id);
			return ResponseEntity.ok(loja);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<Loja> inserir(@RequestBody Loja loja) {
		try {
			Loja nova = service.salvar(loja);
			return ResponseEntity.created(URI.create("/lojas/" + nova.getId())).body(nova);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Loja> atualizar(@PathVariable Integer id, @RequestBody Loja loja) {
		try {
			Loja existente = service.buscarPorId(id);
			loja.setId(existente.getId());
			Loja atualizada = service.salvar(loja);
			return ResponseEntity.ok(atualizada);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		try {
			service.deletar(id);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
}
