package com.uisrael.hikvision.backend.presentacion.dto.request;

import com.uisrael.hikvision.backend.dominio.enums.EstadoRegistro;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PisoRequestDTO {

    @NotNull
    private Integer numeroPiso;

    private String nombre;

    private String descripcion;

    @NotNull
    private EstadoRegistro estado;

    @NotNull
    private Long edificioId;
}
