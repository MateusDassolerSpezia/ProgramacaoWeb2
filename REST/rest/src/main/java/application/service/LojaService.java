package application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import application.model.Loja;
import application.repository.LojaRepository;

@Service
public class LojaService {

    private final LojaRepository repo;

    public LojaService(LojaRepository repo) {
        this.repo = repo;
    }

    public List<Loja> listar() {
        return repo.findAll();
    }

    public Loja salvar(Loja loja) {
        if (loja.getNome() == null || loja.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome da loja não pode ser vazio.");
        }
        return repo.save(loja);
    }

    public Loja buscarPorId(Integer id) {
        return repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Loja não encontrada com id: " + id));
    }

    public void deletar(Integer id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Loja não encontrada para exclusão: " + id);
        }
        repo.deleteById(id);
    }
}