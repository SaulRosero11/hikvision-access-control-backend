package com.uisrael.hikvision.backend.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.hikvision.backend.aplicacion.casouso.entrada.IDispositivoCasoUso;
import com.uisrael.hikvision.backend.presentacion.dto.request.DispositivoRequestDTO;
import com.uisrael.hikvision.backend.presentacion.dto.response.DispositivoResponseDTO;
import com.uisrael.hikvision.backend.presentacion.mapeadores.IDispositivoDtoMapper;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/dispositivo")
public class DispositivoControlador {

  private final IDispositivoCasoUso dispositivoCasoUso;
  private final IDispositivoDtoMapper mapper;

  public DispositivoControlador(IDispositivoCasoUso dispositivoCasoUso, IDispositivoDtoMapper mapper) {
    this.dispositivoCasoUso = dispositivoCasoUso;
    this.mapper = mapper;
  }

  @GetMapping
  public List<DispositivoResponseDTO> listar() {
    return dispositivoCasoUso.listar().stream().map(mapper::toResponseDto).toList();
  }

  @GetMapping("/{id}")
  public DispositivoResponseDTO buscarPorId(@PathVariable Long id) {
    return dispositivoCasoUso.buscarPorId(id)
        .map(mapper::toResponseDto)
        .orElseThrow(() -> new EntityNotFoundException("Dispositivo no encontrado con id: " + id));
  }

  @GetMapping("/codigo/{codigo}")
  public DispositivoResponseDTO buscarPorCodigo(@PathVariable String codigo) {
    return dispositivoCasoUso.buscarPorCodigo(codigo)
        .map(mapper::toResponseDto)
        .orElseThrow(() -> new EntityNotFoundException("Dispositivo no encontrado con codigo: " + codigo));
  }

  @GetMapping("/ip/{ip}")
  public DispositivoResponseDTO buscarPorIp(@PathVariable String ip) {
    return dispositivoCasoUso.buscarPorIp(ip)
        .map(mapper::toResponseDto)
        .orElseThrow(() -> new EntityNotFoundException("Dispositivo no encontrado con ip: " + ip));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public DispositivoResponseDTO guardar(@Valid @RequestBody DispositivoRequestDTO request) {
    return mapper.toResponseDto(dispositivoCasoUso.guardar(mapper.toDomain(request)));
  }

  @PutMapping("/{id}")
  public DispositivoResponseDTO actualizar(@PathVariable Long id, @Valid @RequestBody DispositivoRequestDTO request) {
    return mapper.toResponseDto(dispositivoCasoUso.actualizar(id, mapper.toDomain(request)));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminar(@PathVariable Long id) {
    dispositivoCasoUso.eliminarPorId(id);
    return ResponseEntity.noContent().build();
  }

}
