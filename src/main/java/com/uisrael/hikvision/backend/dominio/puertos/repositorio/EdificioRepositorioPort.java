package com.uisrael.hikvision.backend.dominio.puertos.repositorio;

import com.uisrael.hikvision.backend.dominio.entidades.Edificio;

import java.util.List;
import java.util.Optional;

public interface EdificioRepositorioPort {
    Edificio guardar(Edificio edificio);
    Optional<Edificio> buscarPorId(Long id);
    Optional<Edificio> buscarPorCodigo(String codigo);
    List<Edificio> listar();
    void eliminarPorId(Long id);
    boolean existePorId(Long id);
}
