package com.uisrael.hikvision.backend.aplicacion.casouso.entrada;

import com.uisrael.hikvision.backend.dominio.entidades.Piso;

import java.util.List;
import java.util.Optional;

public interface IPisoCasoUso {
    Piso guardar(Piso piso);
    Optional<Piso> buscarPorId(Long id);
    List<Piso> listarPorEdificioId(Long edificioId);
    List<Piso> listar();
    void eliminarPorId(Long id);
    Piso actualizar(Long id, Piso piso);
}
