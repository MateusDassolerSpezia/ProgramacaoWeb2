package controller;

import model.Produto;
import service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
        Produto produto = service.buscarPorId(id);
        return ResponseEntity.ok(produto);
    }

    @PostMapping
    public ResponseEntity<Produto> inserir(@RequestBody Produto produto) {
        Produto novo = service.salvar(produto);
        return ResponseEntity.status(201).body(novo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Integer id, @RequestBody Produto produto) {
        Produto existente = service.buscarPorId(id);
        produto.setId(existente.getId());
        Produto atualizado = service.salvar(produto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
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
