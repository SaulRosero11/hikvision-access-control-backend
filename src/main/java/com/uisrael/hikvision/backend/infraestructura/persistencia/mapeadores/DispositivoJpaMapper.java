package com.uisrael.hikvision.backend.infraestructura.persistencia.mapeadores;

import com.uisrael.hikvision.backend.dominio.entidades.Dispositivo;
import com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.entidades.DispositivoJpaEntity;
import com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.entidades.PisoJpaEntity;

public class DispositivoJpaMapper {

    public DispositivoJpaEntity aJpa(Dispositivo dominio, PisoJpaEntity piso) {
        if (dominio == null) return null;

        return DispositivoJpaEntity.builder()
                .id(dominio.getId())
                .codigo(dominio.getCodigo())
                .ip(dominio.getIp())
                .puerto(dominio.getPuerto())
                .modelo(dominio.getModelo())
                .ubicacion(dominio.getUbicacion())
                .estado(dominio.getEstado())
                .usuarioDispositivo(dominio.getUsuarioDispositivo())
                .contrasenaDispositivo(dominio.getContrasenaDispositivo())
                .macAddress(dominio.getMacAddress())
                .numeroSerie(dominio.getNumeroSerie())
                .tipoDispositivo(dominio.getTipoDispositivo())
                .firmwareVersion(dominio.getFirmwareVersion())
                .habilitado(dominio.getHabilitado())
                .piso(piso)
                .build();
    }

    public DispositivoJpaEntity aJpa(Dispositivo dominio) {
        return aJpa(dominio, null);
    }

    public Dispositivo aDominio(DispositivoJpaEntity jpa) {
        if (jpa == null) return null;

        return Dispositivo.builder()
                .id(jpa.getId())
                .codigo(jpa.getCodigo())
                .ip(jpa.getIp())
                .puerto(jpa.getPuerto())
                .modelo(jpa.getModelo())
                .ubicacion(jpa.getUbicacion())
                .estado(jpa.getEstado())
                .usuarioDispositivo(jpa.getUsuarioDispositivo())
                .contrasenaDispositivo(jpa.getContrasenaDispositivo())
                .macAddress(jpa.getMacAddress())
                .numeroSerie(jpa.getNumeroSerie())
                .tipoDispositivo(jpa.getTipoDispositivo())
                .firmwareVersion(jpa.getFirmwareVersion())
                .habilitado(jpa.getHabilitado())
                .pisoId(jpa.getPiso() != null ? jpa.getPiso().getId() : null)
                .build();
    }
}
