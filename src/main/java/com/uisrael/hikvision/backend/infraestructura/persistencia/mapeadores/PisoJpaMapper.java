package com.uisrael.hikvision.backend.infraestructura.persistencia.mapeadores;

import com.uisrael.hikvision.backend.dominio.entidades.Piso;
import com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.entidades.EdificioJpaEntity;
import com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.entidades.PisoJpaEntity;

public class PisoJpaMapper {

    public PisoJpaEntity aJpa(Piso dominio, EdificioJpaEntity edificio) {
        if (dominio == null) return null;

        return PisoJpaEntity.builder()
                .id(dominio.getId())
                .numeroPiso(dominio.getNumeroPiso())
                .nombre(dominio.getNombre())
                .descripcion(dominio.getDescripcion())
                .estado(dominio.getEstado())
                .edificio(edificio)
                .build();
    }

    public Piso aDominio(PisoJpaEntity jpa) {
        if (jpa == null) return null;

        return Piso.builder()
                .id(jpa.getId())
                .numeroPiso(jpa.getNumeroPiso())
                .nombre(jpa.getNombre())
                .descripcion(jpa.getDescripcion())
                .estado(jpa.getEstado())
                .edificioId(jpa.getEdificio() != null ? jpa.getEdificio().getId() : null)
                .build();
    }
}
