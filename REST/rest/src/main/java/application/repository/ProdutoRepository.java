package application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import application.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    List<Produto> findByEstoqueLessThan(Integer quantidade);
    List<Produto> findByValorVendaGreaterThan(Double valor);
}