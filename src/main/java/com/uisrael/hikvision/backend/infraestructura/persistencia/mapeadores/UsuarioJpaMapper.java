package com.uisrael.hikvision.backend.infraestructura.persistencia.mapeadores;

import com.uisrael.hikvision.backend.dominio.entidades.ImagenUsuario;
import com.uisrael.hikvision.backend.dominio.entidades.PlanAcceso;
import com.uisrael.hikvision.backend.dominio.entidades.Usuario;
import com.uisrael.hikvision.backend.dominio.entidades.UsuarioPisoPermiso;
import com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.entidades.ImagenUsuarioJpaEntity;
import com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.entidades.PlanAccesoJpaEntity;
import com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.entidades.UsuarioJpaEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioJpaMapper {

    private final ValidezAccesoJpaMapper validezMapper = new ValidezAccesoJpaMapper();
    private final PlanAccesoJpaMapper planAccesoMapper = new PlanAccesoJpaMapper();
    private final ImagenUsuarioJpaMapper imagenMapper = new ImagenUsuarioJpaMapper();
    private final UsuarioPisoPermisoJpaMapper permisoMapper = new UsuarioPisoPermisoJpaMapper();

    public UsuarioJpaEntity aJpa(Usuario dominio) {
        if (dominio == null) return null;

        UsuarioJpaEntity usuarioJpa = UsuarioJpaEntity.builder()
                .id(dominio.getId())
                .identificacion(dominio.getIdentificacion())
                .nombreCompleto(dominio.getNombreCompleto())
                .tipoUsuario(dominio.getTipoUsuario())
                .estado(dominio.getEstado())
                .fechaRegistro(dominio.getFechaRegistro())
                .genero(dominio.getGenero())
                .numeroHabitacion(dominio.getNumeroHabitacion())
                .numeroPiso(dominio.getNumeroPiso())
                .derechoPuerta(dominio.getDerechoPuerta())
                .derechoUILocal(dominio.getDerechoUILocal())
                .validez(validezMapper.aJpa(dominio.getValidez()))
                .planesAcceso(new ArrayList<>())
                .imagenes(new ArrayList<>())
                .permisosPisos(new ArrayList<>())
                .build();

        // Mapear planes de acceso
        if (dominio.getPlanesAcceso() != null) {
            for (PlanAcceso plan : dominio.getPlanesAcceso()) {
                PlanAccesoJpaEntity planJpa = planAccesoMapper.aJpa(plan, usuarioJpa);
                usuarioJpa.getPlanesAcceso().add(planJpa);
            }
        }

        // Mapear imagenes
        if (dominio.getImagenes() != null) {
            for (ImagenUsuario imagen : dominio.getImagenes()) {
                ImagenUsuarioJpaEntity imagenJpa = imagenMapper.aJpa(imagen, usuarioJpa);
                usuarioJpa.getImagenes().add(imagenJpa);
            }
        }

        return usuarioJpa;
    }

    public Usuario aDominio(UsuarioJpaEntity jpa) {
        if (jpa == null) return null;

        List<PlanAcceso> planesAcceso = null;
        if (jpa.getPlanesAcceso() != null) {
            planesAcceso = jpa.getPlanesAcceso().stream()
                    .map(planAccesoMapper::aDominio)
                    .collect(Collectors.toList());
        }

        List<ImagenUsuario> imagenes = null;
        if (jpa.getImagenes() != null) {
            imagenes = jpa.getImagenes().stream()
                    .map(imagenMapper::aDominio)
                    .collect(Collectors.toList());
        }

        List<UsuarioPisoPermiso> permisosPisos = null;
        if (jpa.getPermisosPisos() != null) {
            permisosPisos = jpa.getPermisosPisos().stream()
                    .map(permisoMapper::aDominio)
                    .collect(Collectors.toList());
        }

        return Usuario.builder()
                .id(jpa.getId())
                .identificacion(jpa.getIdentificacion())
                .nombreCompleto(jpa.getNombreCompleto())
                .tipoUsuario(jpa.getTipoUsuario())
                .estado(jpa.getEstado())
                .fechaRegistro(jpa.getFechaRegistro())
                .genero(jpa.getGenero())
                .numeroHabitacion(jpa.getNumeroHabitacion())
                .numeroPiso(jpa.getNumeroPiso())
                .derechoPuerta(jpa.getDerechoPuerta())
                .derechoUILocal(jpa.getDerechoUILocal())
                .validez(validezMapper.aDominio(jpa.getValidez()))
                .planesAcceso(planesAcceso)
                .imagenes(imagenes)
                .permisospisos(permisosPisos)
                .build();
    }
}
