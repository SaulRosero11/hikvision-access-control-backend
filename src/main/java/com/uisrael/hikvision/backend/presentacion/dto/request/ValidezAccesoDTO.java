package com.uisrael.hikvision.backend.presentacion.dto.request;

import com.uisrael.hikvision.backend.dominio.enums.TipoTiempo;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ValidezAccesoDTO {
    private Boolean habilitado;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private TipoTiempo tipoTiempo;
}
