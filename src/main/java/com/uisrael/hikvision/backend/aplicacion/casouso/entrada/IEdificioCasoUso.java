package com.uisrael.hikvision.backend.aplicacion.casouso.entrada;

import com.uisrael.hikvision.backend.dominio.entidades.Edificio;

import java.util.List;
import java.util.Optional;

public interface IEdificioCasoUso {
    Edificio guardar(Edificio edificio);
    Optional<Edificio> buscarPorId(Long id);
    Optional<Edificio> buscarPorCodigo(String codigo);
    List<Edificio> listar();
    void eliminarPorId(Long id);
    Edificio actualizar(Long id, Edificio edificio);
}
