package com.uisrael.hikvision.backend.aplicacion.casouso.entrada;

import java.util.List;
import java.util.Optional;

import com.uisrael.hikvision.backend.dominio.entidades.Dispositivo;

public interface IDispositivoCasoUso {
    Dispositivo guardar(Dispositivo dispositivo);
    Optional<Dispositivo> buscarPorId(Long id);
    Optional<Dispositivo> buscarPorCodigo(String codigo);
    Optional<Dispositivo> buscarPorIp(String ip);
    Optional<Dispositivo> buscarPorMacAddress(String macAddress);
    List<Dispositivo> listarPorPisoId(Long pisoId);
    List<Dispositivo> listar();
    void eliminarPorId(Long id);
    Dispositivo actualizar(Long id, Dispositivo dispositivo);
}
