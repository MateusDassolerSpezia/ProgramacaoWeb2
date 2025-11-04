package service;

import model.Produto;
import repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repo;

    public ProdutoService(ProdutoRepository repo) {
        this.repo = repo;
    }

    public List<Produto> listar() {
        return repo.findAll();
    }

    public Produto salvar(Produto p) {
        if (p.getValorVenda() != null && p.getValorVenda() < 0)
            throw new IllegalArgumentException("O valor de venda não pode ser negativo.");

        if (p.getValorCusto() != null && p.getValorCusto() < 0)
            throw new IllegalArgumentException("O valor de custo não pode ser negativo.");

        if (p.getEstoque() != null && p.getEstoque() < 0)
            throw new IllegalArgumentException("O estoque não pode ser negativo.");

        return repo.save(p);
    }

    public Produto buscarPorId(Integer id) {
        return repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Produto não encontrado com id: " + id));
    }

    public void deletar(Integer id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("Produto não encontrado para exclusão: " + id);
        }
        repo.deleteById(id);
    }

    public List<Produto> estoqueBaixo() {
        return repo.findByEstoqueLessThan(10);
    }

    public List<Produto> valorMaiorQue(Double valor) {
        return repo.findByValorVendaGreaterThan(valor);
    }
}
