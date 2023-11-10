package br.edu.fateczl.ExemploSpringRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fateczl.ExemploSpringRest.model.entity.Depto;

public interface DeptoRepository extends JpaRepository<Depto, Integer> {
}
