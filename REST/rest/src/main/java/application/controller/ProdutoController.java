package application.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.model.Produto;
import application.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Produto> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscar(@PathVariable Integer id) {
    	try {
        Produto produto = service.buscarPorId(id);
        return ResponseEntity.ok(produto);
    	} catch (Exception e) {
    		return ResponseEntity.notFound().build();
    	}
    }

    @PostMapping
    public ResponseEntity<Produto> inserir(@RequestBody Produto produto) {
    	try {
        Produto novo = service.salvar(produto);
        return ResponseEntity.created(URI.create("/produtos/" + novo.getId())).body(novo);
    	} catch (Exception e) {
    		return ResponseEntity.badRequest().build();
    	}
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Integer id, @RequestBody Produto produto) {
    	try {
        Produto existente = service.buscarPorId(id);
        produto.setId(existente.getId());
        Produto atualizado = service.salvar(produto);
        return ResponseEntity.ok(atualizado);
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

    // SELECTS EXTRAS
    @GetMapping("/estoque/baixo")
    public List<Produto> estoqueBaixo() {
        return service.estoqueBaixo();
    }

    @GetMapping("/valor-maior/{valor}")
    public List<Produto> valorMaior(@PathVariable Double valor) {
        return service.valorMaiorQue(valor);
    }
}
