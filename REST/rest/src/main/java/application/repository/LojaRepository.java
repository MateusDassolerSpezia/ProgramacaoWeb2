package application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import application.model.Loja;

public interface LojaRepository extends JpaRepository<Loja, Integer> {
}