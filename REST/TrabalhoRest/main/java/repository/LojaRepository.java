package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import model.Loja;

public interface LojaRepository extends JpaRepository<Loja, Integer> {
}