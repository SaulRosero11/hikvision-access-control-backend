package com.uisrael.hikvision.backend.dominio.puertos.repositorio;

import com.uisrael.hikvision.backend.dominio.entidades.PlanAcceso;

import java.util.List;
import java.util.Optional;

public interface PlanAccesoRepositorioPort {
    PlanAcceso guardar(PlanAcceso planAcceso);
    Optional<PlanAcceso> buscarPorId(Long id);
    List<PlanAcceso> listarPorUsuarioId(Long usuarioId);
    void eliminarPorId(Long id);
    void eliminarPorUsuarioId(Long usuarioId);
}
