package com.uisrael.hikvision.backend.aplicacion.casouso.entrada;

import com.uisrael.hikvision.backend.dominio.entidades.UsuarioPisoPermiso;

import java.util.List;
import java.util.Optional;

public interface IUsuarioPisoPermisoCasoUso {
    UsuarioPisoPermiso guardar(UsuarioPisoPermiso permiso);
    Optional<UsuarioPisoPermiso> buscarPorId(Long id);
    Optional<UsuarioPisoPermiso> buscarPorUsuarioYPiso(Long usuarioId, Long pisoId);
    List<UsuarioPisoPermiso> listarPorUsuarioId(Long usuarioId);
    List<UsuarioPisoPermiso> listarPorPisoId(Long pisoId);
    List<UsuarioPisoPermiso> listar();
    void eliminarPorId(Long id);
    UsuarioPisoPermiso actualizar(Long id, UsuarioPisoPermiso permiso);
}
