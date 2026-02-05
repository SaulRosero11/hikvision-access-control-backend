package com.uisrael.hikvision.backend.dominio.puertos.repositorio;

import com.uisrael.hikvision.backend.dominio.entidades.UsuarioPisoPermiso;

import java.util.List;
import java.util.Optional;

public interface UsuarioPisoPermisoRepositorioPort {
    UsuarioPisoPermiso guardar(UsuarioPisoPermiso permiso);
    Optional<UsuarioPisoPermiso> buscarPorId(Long id);
    Optional<UsuarioPisoPermiso> buscarPorUsuarioYPiso(Long usuarioId, Long pisoId);
    List<UsuarioPisoPermiso> listarPorUsuarioId(Long usuarioId);
    List<UsuarioPisoPermiso> listarPorPisoId(Long pisoId);
    List<UsuarioPisoPermiso> listar();
    void eliminarPorId(Long id);
    void eliminarPorUsuarioId(Long usuarioId);
    boolean existePorId(Long id);
}
