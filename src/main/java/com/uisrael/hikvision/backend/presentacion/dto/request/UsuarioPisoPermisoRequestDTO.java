package com.uisrael.hikvision.backend.presentacion.dto.request;

import com.uisrael.hikvision.backend.dominio.enums.EstadoRegistro;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UsuarioPisoPermisoRequestDTO {

    @NotNull
    private Long usuarioId;

    @NotNull
    private Long pisoId;

    @NotNull
    private Boolean accesoPermitido;

    @NotNull
    private LocalDateTime fechaAsignacion;

    private LocalDateTime fechaExpiracion;

    @NotNull
    private EstadoRegistro estado;

    private String observaciones;
}
