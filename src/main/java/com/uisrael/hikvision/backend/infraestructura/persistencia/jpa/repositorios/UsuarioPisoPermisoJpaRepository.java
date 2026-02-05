package com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.repositorios;

import com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.entidades.UsuarioPisoPermisoJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioPisoPermisoJpaRepository extends JpaRepository<UsuarioPisoPermisoJpaEntity, Long> {
    Optional<UsuarioPisoPermisoJpaEntity> findByUsuario_IdAndPiso_Id(Long usuarioId, Long pisoId);
    List<UsuarioPisoPermisoJpaEntity> findByUsuario_Id(Long usuarioId);
    List<UsuarioPisoPermisoJpaEntity> findByPiso_Id(Long pisoId);
    void deleteByUsuario_Id(Long usuarioId);
}
