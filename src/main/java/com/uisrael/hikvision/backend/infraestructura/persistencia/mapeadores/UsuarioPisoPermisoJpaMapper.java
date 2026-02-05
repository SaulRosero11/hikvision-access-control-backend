package com.uisrael.hikvision.backend.infraestructura.persistencia.mapeadores;

import com.uisrael.hikvision.backend.dominio.entidades.UsuarioPisoPermiso;
import com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.entidades.PisoJpaEntity;
import com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.entidades.UsuarioJpaEntity;
import com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.entidades.UsuarioPisoPermisoJpaEntity;

public class UsuarioPisoPermisoJpaMapper {

    public UsuarioPisoPermisoJpaEntity aJpa(UsuarioPisoPermiso dominio, UsuarioJpaEntity usuario, PisoJpaEntity piso) {
        if (dominio == null) return null;

        return UsuarioPisoPermisoJpaEntity.builder()
                .id(dominio.getId())
                .usuario(usuario)
                .piso(piso)
                .accesoPermitido(dominio.getAccesoPermitido())
                .fechaAsignacion(dominio.getFechaAsignacion())
                .fechaExpiracion(dominio.getFechaExpiracion())
                .estado(dominio.getEstado())
                .observaciones(dominio.getObservaciones())
                .build();
    }

    public UsuarioPisoPermiso aDominio(UsuarioPisoPermisoJpaEntity jpa) {
        if (jpa == null) return null;

        return UsuarioPisoPermiso.builder()
                .id(jpa.getId())
                .usuarioId(jpa.getUsuario() != null ? jpa.getUsuario().getId() : null)
                .pisoId(jpa.getPiso() != null ? jpa.getPiso().getId() : null)
                .accesoPermitido(jpa.getAccesoPermitido())
                .fechaAsignacion(jpa.getFechaAsignacion())
                .fechaExpiracion(jpa.getFechaExpiracion())
                .estado(jpa.getEstado())
                .observaciones(jpa.getObservaciones())
                .build();
    }
}
