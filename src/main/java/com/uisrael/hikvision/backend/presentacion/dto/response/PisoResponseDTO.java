package com.uisrael.hikvision.backend.presentacion.dto.response;

import com.uisrael.hikvision.backend.dominio.enums.EstadoRegistro;
import lombok.Data;

@Data
public class PisoResponseDTO {
    private Long id;
    private Integer numeroPiso;
    private String nombre;
    private String descripcion;
    private EstadoRegistro estado;
    private Long edificioId;
}
