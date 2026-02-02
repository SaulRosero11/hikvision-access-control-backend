package com.uisrael.hikvision.backend.presentacion.dto.request;

import com.uisrael.hikvision.backend.dominio.enums.EstadoRegistro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DispositivoRequestDTO {

  // private final Long id;
  @NotBlank
  private String codigo;
  @NotBlank
  private String ip;
  @NotNull
  private Integer puerto;
  @NotBlank
  private String modelo;
  @NotBlank
  private String ubicacion;
  @NotNull
  private EstadoRegistro estado;

}
