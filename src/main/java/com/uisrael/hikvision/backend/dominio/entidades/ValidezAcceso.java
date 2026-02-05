package com.uisrael.hikvision.backend.dominio.entidades;

import com.uisrael.hikvision.backend.dominio.enums.TipoTiempo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class ValidezAcceso {
    private final Boolean habilitado;
    private final LocalDateTime fechaInicio;
    private final LocalDateTime fechaFin;
    private final TipoTiempo tipoTiempo;
}
