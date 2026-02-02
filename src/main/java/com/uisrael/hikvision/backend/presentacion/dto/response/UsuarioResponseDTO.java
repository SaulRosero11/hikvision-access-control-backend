package com.uisrael.hikvision.backend.presentacion.dto.response;

import java.time.LocalDateTime;

import com.uisrael.hikvision.backend.dominio.enums.EstadoRegistro;
import com.uisrael.hikvision.backend.dominio.enums.TipoUsuario;

public class UsuarioResponseDTO {

  private Long id;
  private String identificacion;
  private String nombreCompleto;
  private TipoUsuario tipoUsuario;
  private EstadoRegistro estado;
  private LocalDateTime fechaRegistro;
  
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getIdentificacion() {
    return identificacion;
  }
  public void setIdentificacion(String identificacion) {
    this.identificacion = identificacion;
  }
  public String getNombreCompleto() {
    return nombreCompleto;
  }
  public void setNombreCompleto(String nombreCompleto) {
    this.nombreCompleto = nombreCompleto;
  }
  public TipoUsuario getTipoUsuario() {
    return tipoUsuario;
  }
  public void setTipoUsuario(TipoUsuario tipoUsuario) {
    this.tipoUsuario = tipoUsuario;
  }
  public EstadoRegistro getEstado() {
    return estado;
  }
  public void setEstado(EstadoRegistro estado) {
    this.estado = estado;
  }
  public LocalDateTime getFechaRegistro() {
    return fechaRegistro;
  }
  public void setFechaRegistro(LocalDateTime fechaRegistro) {
    this.fechaRegistro = fechaRegistro;
  }

  

}
