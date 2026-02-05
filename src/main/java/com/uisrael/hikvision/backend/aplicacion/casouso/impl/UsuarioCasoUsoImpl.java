package com.uisrael.hikvision.backend.aplicacion.casouso.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uisrael.hikvision.backend.aplicacion.casouso.entrada.IUsuarioCasoUso;
import com.uisrael.hikvision.backend.dominio.entidades.Usuario;
import com.uisrael.hikvision.backend.dominio.puertos.repositorio.UsuarioRepositorioPort;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class UsuarioCasoUsoImpl implements IUsuarioCasoUso {

    private final UsuarioRepositorioPort repositorio;

    public UsuarioCasoUsoImpl(UsuarioRepositorioPort repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        return repositorio.guardar(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> buscarPorId(Long id) {
        return repositorio.buscarPorId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> buscarPorIdentificacion(String identificacion) {
        return repositorio.buscarPorIdentificacion(identificacion);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> listar() {
        return repositorio.listar();
    }

    @Override
    public void eliminarPorId(Long id) {
        repositorio.eliminarPorId(id);
    }

    @Override
    public Usuario actualizar(Long id, Usuario usuario) {
        if (!repositorio.existePorId(id)) {
            throw new EntityNotFoundException("Usuario no encontrado con id: " + id);
        }
        Usuario usuarioActualizado = Usuario.builder()
                .id(id)
                .identificacion(usuario.getIdentificacion())
                .nombreCompleto(usuario.getNombreCompleto())
                .tipoUsuario(usuario.getTipoUsuario())
                .estado(usuario.getEstado())
                .fechaRegistro(usuario.getFechaRegistro())
                .genero(usuario.getGenero())
                .numeroHabitacion(usuario.getNumeroHabitacion())
                .numeroPiso(usuario.getNumeroPiso())
                .derechoPuerta(usuario.getDerechoPuerta())
                .derechoUILocal(usuario.getDerechoUILocal())
                .validez(usuario.getValidez())
                .planesAcceso(usuario.getPlanesAcceso())
                .imagenes(usuario.getImagenes())
                .permisospisos(usuario.getPermisospisos())
                .build();
        return repositorio.guardar(usuarioActualizado);
    }
}
