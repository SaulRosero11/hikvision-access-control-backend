package com.uisrael.hikvision.backend.infraestructura.persistencia.mapeadores;

import com.uisrael.hikvision.backend.dominio.entidades.PlanAcceso;
import com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.entidades.PlanAccesoJpaEntity;
import com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.entidades.UsuarioJpaEntity;

public class PlanAccesoJpaMapper {

    public PlanAccesoJpaEntity aJpa(PlanAcceso dominio, UsuarioJpaEntity usuario) {
        if (dominio == null) return null;

        return PlanAccesoJpaEntity.builder()
                .id(dominio.getId())
                .numeroPuerta(dominio.getNumeroPuerta())
                .numeroPlantilla(dominio.getNumeroPlantilla())
                .usuario(usuario)
                .build();
    }

    public PlanAcceso aDominio(PlanAccesoJpaEntity jpa) {
        if (jpa == null) return null;

        return PlanAcceso.builder()
                .id(jpa.getId())
                .numeroPuerta(jpa.getNumeroPuerta())
                .numeroPlantilla(jpa.getNumeroPlantilla())
                .usuarioId(jpa.getUsuario() != null ? jpa.getUsuario().getId() : null)
                .build();
    }
}
