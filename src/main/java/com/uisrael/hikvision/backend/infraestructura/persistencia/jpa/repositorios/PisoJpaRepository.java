package com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.repositorios;

import com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.entidades.PisoJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PisoJpaRepository extends JpaRepository<PisoJpaEntity, Long> {
    List<PisoJpaEntity> findByEdificio_Id(Long edificioId);
}
