package com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.repositorios;

import com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.entidades.ImagenUsuarioJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImagenUsuarioJpaRepository extends JpaRepository<ImagenUsuarioJpaEntity, Long> {
    List<ImagenUsuarioJpaEntity> findByUsuario_Id(Long usuarioId);
    void deleteByUsuario_Id(Long usuarioId);
}
