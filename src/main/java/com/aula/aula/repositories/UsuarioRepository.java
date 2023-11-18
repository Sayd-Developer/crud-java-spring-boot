package com.aula.aula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aula.aula.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


}
