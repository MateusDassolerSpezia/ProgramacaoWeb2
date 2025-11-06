package application.controller;

import application.model.Loja;
import application.service.LojaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
        Loja loja = service.buscarPorId(id);
        return ResponseEntity.ok(loja);
    }

    @PostMapping
    public ResponseEntity<Loja> inserir(@RequestBody Loja loja) {
        Loja nova = service.salvar(loja);
        return ResponseEntity.status(201).body(nova);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Loja> atualizar(@PathVariable Integer id, @RequestBody Loja loja) {
        Loja existente = service.buscarPorId(id);
        loja.setId(existente.getId());
        Loja atualizada = service.salvar(loja);
        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
