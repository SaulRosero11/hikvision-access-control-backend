package com.uisrael.hikvision.backend.dominio.puertos.repositorio;

import com.uisrael.hikvision.backend.dominio.entidades.Dispositivo;

import java.util.List;
import java.util.Optional;

public interface DispositivoRepositorioPort {
    Dispositivo guardar(Dispositivo dispositivo);
    Optional<Dispositivo> buscarPorId(Long id);
    Optional<Dispositivo> buscarPorCodigo(String codigo);
    Optional<Dispositivo> buscarPorIp(String ip);
    Optional<Dispositivo> buscarPorMacAddress(String macAddress);
    List<Dispositivo> listarPorPisoId(Long pisoId);
    List<Dispositivo> listar();
    void eliminarPorId(Long id);
    boolean existePorId(Long id);
}
