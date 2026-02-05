package com.uisrael.hikvision.backend.presentacion.dto.request;

import com.uisrael.hikvision.backend.dominio.enums.EstadoRegistro;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EdificioRequestDTO {

    @NotBlank
    private String codigo;

    @NotBlank
    private String nombre;

    private String direccion;

    @NotNull
    @Min(1)
    private Integer numeroPisos;

    private String descripcion;

    private String telefono;

    private String email;

    @NotNull
    private EstadoRegistro estado;

    @NotNull
    private LocalDateTime fechaCreacion;
}
