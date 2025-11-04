package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import model.Produto;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    List<Produto> findByEstoqueLessThan(Integer quantidade);
    List<Produto> findByValorVendaGreaterThan(Double valor);
}