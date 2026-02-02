package com.uisrael.hikvision.backend.aplicacion.casouso.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.uisrael.hikvision.backend.aplicacion.casouso.entrada.IDispositivoCasoUso;
import com.uisrael.hikvision.backend.dominio.entidades.Dispositivo;
import com.uisrael.hikvision.backend.dominio.puertos.repositorio.DispositivoRepositorioPort;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DispositivoCasoUsoImpl implements IDispositivoCasoUso {

  private final DispositivoRepositorioPort repositorio;

  public DispositivoCasoUsoImpl(DispositivoRepositorioPort repositorio) {
    this.repositorio = repositorio;
  }

  @Override
  public Dispositivo guardar(Dispositivo dispositivo) {

    return repositorio.guardar(dispositivo);
  }

  @Override
  public Optional<Dispositivo> buscarPorId(Long id) {

    return repositorio.buscarPorId(id);
  }

  @Override
  public Optional<Dispositivo> buscarPorCodigo(String codigo) {

    return repositorio.buscarPorCodigo(codigo);
  }

  @Override
  public Optional<Dispositivo> buscarPorIp(String ip) {

    return repositorio.buscarPorIp(ip);
  }

  @Override
  public List<Dispositivo> listar() {

    return repositorio.listar();
  }

  @Override
  public void eliminarPorId(Long id) {

    repositorio.eliminarPorId(id);
  }

  @Override
  public Dispositivo actualizar(Long id, Dispositivo dispositivo) {
    if (!repositorio.existePorId(id)) {
      throw new EntityNotFoundException("Dispositivo no encontrado con id: " + id);
    }
    Dispositivo dispositivoActualizado = Dispositivo.builder()
        .id(id)
        .codigo(dispositivo.getCodigo())
        .ip(dispositivo.getIp())
        .puerto(dispositivo.getPuerto())
        .modelo(dispositivo.getModelo())
        .ubicacion(dispositivo.getUbicacion())
        .estado(dispositivo.getEstado())
        .build();
    return repositorio.guardar(dispositivoActualizado);
  }

}
