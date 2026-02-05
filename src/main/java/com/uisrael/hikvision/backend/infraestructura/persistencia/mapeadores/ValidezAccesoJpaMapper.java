package com.uisrael.hikvision.backend.infraestructura.persistencia.mapeadores;

import com.uisrael.hikvision.backend.dominio.entidades.ValidezAcceso;
import com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.entidades.ValidezAccesoEmbeddable;

public class ValidezAccesoJpaMapper {

    public ValidezAccesoEmbeddable aJpa(ValidezAcceso dominio) {
        if (dominio == null) return null;

        return ValidezAccesoEmbeddable.builder()
                .habilitado(dominio.getHabilitado())
                .fechaInicio(dominio.getFechaInicio())
                .fechaFin(dominio.getFechaFin())
                .tipoTiempo(dominio.getTipoTiempo())
                .build();
    }

    public ValidezAcceso aDominio(ValidezAccesoEmbeddable jpa) {
        if (jpa == null) return null;

        return ValidezAcceso.builder()
                .habilitado(jpa.getHabilitado())
                .fechaInicio(jpa.getFechaInicio())
                .fechaFin(jpa.getFechaFin())
                .tipoTiempo(jpa.getTipoTiempo())
                .build();
    }
}
