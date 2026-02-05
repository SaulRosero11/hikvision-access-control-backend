package com.uisrael.hikvision.backend.presentacion.dto.response;

import com.uisrael.hikvision.backend.dominio.enums.EstadoRegistro;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UsuarioPisoPermisoResponseDTO {
    private Long id;
    private Long usuarioId;
    private Long pisoId;
    private Boolean accesoPermitido;
    private LocalDateTime fechaAsignacion;
    private LocalDateTime fechaExpiracion;
    private EstadoRegistro estado;
    private String observaciones;
}
