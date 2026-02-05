package com.uisrael.hikvision.backend.dominio.puertos.repositorio;

import com.uisrael.hikvision.backend.dominio.entidades.Piso;

import java.util.List;
import java.util.Optional;

public interface PisoRepositorioPort {
    Piso guardar(Piso piso);
    Optional<Piso> buscarPorId(Long id);
    List<Piso> listarPorEdificioId(Long edificioId);
    List<Piso> listar();
    void eliminarPorId(Long id);
    boolean existePorId(Long id);
}
