package com.acm.taller2.persistence.repository;

import acm.taller2.persistence.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity,Long> {
}
