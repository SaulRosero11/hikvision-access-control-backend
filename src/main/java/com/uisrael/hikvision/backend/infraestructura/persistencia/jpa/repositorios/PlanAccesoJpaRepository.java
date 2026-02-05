package com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.repositorios;

import com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.entidades.PlanAccesoJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanAccesoJpaRepository extends JpaRepository<PlanAccesoJpaEntity, Long> {
    List<PlanAccesoJpaEntity> findByUsuario_Id(Long usuarioId);
    void deleteByUsuario_Id(Long usuarioId);
}
