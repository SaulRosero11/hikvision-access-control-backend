package com.uisrael.hikvision.backend.infraestructura.persistencia.mapeadores;

import com.uisrael.hikvision.backend.dominio.entidades.ImagenUsuario;
import com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.entidades.ImagenUsuarioJpaEntity;
import com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.entidades.UsuarioJpaEntity;

public class ImagenUsuarioJpaMapper {

    public ImagenUsuarioJpaEntity aJpa(ImagenUsuario dominio, UsuarioJpaEntity usuario) {
        if (dominio == null) return null;

        return ImagenUsuarioJpaEntity.builder()
                .id(dominio.getId())
                .imagenBase64(dominio.getImagenBase64())
                .tipoImagen(dominio.getTipoImagen())
                .usuario(usuario)
                .build();
    }

    public ImagenUsuario aDominio(ImagenUsuarioJpaEntity jpa) {
        if (jpa == null) return null;

        return ImagenUsuario.builder()
                .id(jpa.getId())
                .imagenBase64(jpa.getImagenBase64())
                .tipoImagen(jpa.getTipoImagen())
                .usuarioId(jpa.getUsuario() != null ? jpa.getUsuario().getId() : null)
                .build();
    }
}
