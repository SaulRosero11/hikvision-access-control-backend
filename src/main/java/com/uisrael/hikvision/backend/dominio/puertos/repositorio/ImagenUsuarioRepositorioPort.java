package com.uisrael.hikvision.backend.dominio.puertos.repositorio;

import com.uisrael.hikvision.backend.dominio.entidades.ImagenUsuario;

import java.util.List;
import java.util.Optional;

public interface ImagenUsuarioRepositorioPort {
    ImagenUsuario guardar(ImagenUsuario imagenUsuario);
    Optional<ImagenUsuario> buscarPorId(Long id);
    List<ImagenUsuario> listarPorUsuarioId(Long usuarioId);
    void eliminarPorId(Long id);
    void eliminarPorUsuarioId(Long usuarioId);
}
