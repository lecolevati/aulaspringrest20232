package br.edu.fateczl.ExemploSpringRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fateczl.ExemploSpringRest.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
}
