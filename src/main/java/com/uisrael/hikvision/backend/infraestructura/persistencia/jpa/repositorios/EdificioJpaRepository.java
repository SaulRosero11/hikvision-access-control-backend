package com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.repositorios;

import com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.entidades.EdificioJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EdificioJpaRepository extends JpaRepository<EdificioJpaEntity, Long> {
    Optional<EdificioJpaEntity> findByCodigo(String codigo);
}
