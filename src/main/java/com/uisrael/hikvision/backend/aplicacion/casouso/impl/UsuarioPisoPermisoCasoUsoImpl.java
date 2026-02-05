package com.uisrael.hikvision.backend.aplicacion.casouso.impl;

import com.uisrael.hikvision.backend.aplicacion.casouso.entrada.IUsuarioPisoPermisoCasoUso;
import com.uisrael.hikvision.backend.dominio.entidades.UsuarioPisoPermiso;
import com.uisrael.hikvision.backend.dominio.puertos.repositorio.UsuarioPisoPermisoRepositorioPort;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioPisoPermisoCasoUsoImpl implements IUsuarioPisoPermisoCasoUso {

    private final UsuarioPisoPermisoRepositorioPort repositorio;

    public UsuarioPisoPermisoCasoUsoImpl(UsuarioPisoPermisoRepositorioPort repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public UsuarioPisoPermiso guardar(UsuarioPisoPermiso permiso) {
        return repositorio.guardar(permiso);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UsuarioPisoPermiso> buscarPorId(Long id) {
        return repositorio.buscarPorId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UsuarioPisoPermiso> buscarPorUsuarioYPiso(Long usuarioId, Long pisoId) {
        return repositorio.buscarPorUsuarioYPiso(usuarioId, pisoId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioPisoPermiso> listarPorUsuarioId(Long usuarioId) {
        return repositorio.listarPorUsuarioId(usuarioId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioPisoPermiso> listarPorPisoId(Long pisoId) {
        return repositorio.listarPorPisoId(pisoId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioPisoPermiso> listar() {
        return repositorio.listar();
    }

    @Override
    public void eliminarPorId(Long id) {
        repositorio.eliminarPorId(id);
    }

    @Override
    public UsuarioPisoPermiso actualizar(Long id, UsuarioPisoPermiso permiso) {
        if (!repositorio.existePorId(id)) {
            throw new EntityNotFoundException("Permiso no encontrado con id: " + id);
        }
        UsuarioPisoPermiso permisoActualizado = UsuarioPisoPermiso.builder()
                .id(id)
                .usuarioId(permiso.getUsuarioId())
                .pisoId(permiso.getPisoId())
                .accesoPermitido(permiso.getAccesoPermitido())
                .fechaAsignacion(permiso.getFechaAsignacion())
                .fechaExpiracion(permiso.getFechaExpiracion())
                .estado(permiso.getEstado())
                .observaciones(permiso.getObservaciones())
                .build();
        return repositorio.guardar(permisoActualizado);
    }
}
