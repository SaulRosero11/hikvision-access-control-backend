package com.uisrael.hikvision.backend.presentacion.dto.response;

import com.uisrael.hikvision.backend.dominio.enums.EstadoRegistro;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EdificioResponseDTO {
    private Long id;
    private String codigo;
    private String nombre;
    private String direccion;
    private Integer numeroPisos;
    private String descripcion;
    private String telefono;
    private String email;
    private EstadoRegistro estado;
    private LocalDateTime fechaCreacion;
}
