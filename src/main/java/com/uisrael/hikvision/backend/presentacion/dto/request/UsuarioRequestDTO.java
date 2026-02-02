package com.uisrael.hikvision.backend.presentacion.dto.request;

import java.time.LocalDateTime;

import com.uisrael.hikvision.backend.dominio.enums.EstadoRegistro;
import com.uisrael.hikvision.backend.dominio.enums.TipoUsuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UsuarioRequestDTO {

  // private final Long id;

  @NotBlank
  private String identificacion;
  @NotBlank
  private String nombreCompleto;
  @NotNull
  private TipoUsuario tipoUsuario;
  @NotNull
  private EstadoRegistro estado;
  @NotNull
  private LocalDateTime fechaRegistro;
}
