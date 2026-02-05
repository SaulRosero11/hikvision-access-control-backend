package com.uisrael.hikvision.backend.presentacion.dto.response;

import com.uisrael.hikvision.backend.dominio.enums.TipoTiempo;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ValidezAccesoResponseDTO {
    private Boolean habilitado;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private TipoTiempo tipoTiempo;
}
