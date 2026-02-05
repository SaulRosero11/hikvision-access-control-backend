package com.uisrael.hikvision.backend.infraestructura.persistencia.mapeadores;

import com.uisrael.hikvision.backend.dominio.entidades.Edificio;
import com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.entidades.EdificioJpaEntity;

public class EdificioJpaMapper {

    public EdificioJpaEntity aJpa(Edificio dominio) {
        if (dominio == null) return null;

        return EdificioJpaEntity.builder()
                .id(dominio.getId())
                .codigo(dominio.getCodigo())
                .nombre(dominio.getNombre())
                .direccion(dominio.getDireccion())
                .numeroPisos(dominio.getNumeroPisos())
                .descripcion(dominio.getDescripcion())
                .telefono(dominio.getTelefono())
                .email(dominio.getEmail())
                .estado(dominio.getEstado())
                .fechaCreacion(dominio.getFechaCreacion())
                .build();
    }

    public Edificio aDominio(EdificioJpaEntity jpa) {
        if (jpa == null) return null;

        return Edificio.builder()
                .id(jpa.getId())
                .codigo(jpa.getCodigo())
                .nombre(jpa.getNombre())
                .direccion(jpa.getDireccion())
                .numeroPisos(jpa.getNumeroPisos())
                .descripcion(jpa.getDescripcion())
                .telefono(jpa.getTelefono())
                .email(jpa.getEmail())
                .estado(jpa.getEstado())
                .fechaCreacion(jpa.getFechaCreacion())
                .build();
    }
}
