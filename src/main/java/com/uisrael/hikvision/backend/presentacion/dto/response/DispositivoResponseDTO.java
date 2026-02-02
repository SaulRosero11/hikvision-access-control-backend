package com.uisrael.hikvision.backend.presentacion.dto.response;

import com.uisrael.hikvision.backend.dominio.enums.EstadoRegistro;

public class DispositivoResponseDTO {

  private Long id;
  private String codigo;
  private String ip;
  private Integer puerto;
  private String modelo;
  private String ubicacion;
  private EstadoRegistro estado;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public Integer getPuerto() {
    return puerto;
  }

  public void setPuerto(Integer puerto) {
    this.puerto = puerto;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public String getUbicacion() {
    return ubicacion;
  }

  public void setUbicacion(String ubicacion) {
    this.ubicacion = ubicacion;
  }

  public EstadoRegistro getEstado() {
    return estado;
  }

  public void setEstado(EstadoRegistro estado) {
    this.estado = estado;
  }

}
