package com.uisrael.hikvision.backend.presentacion.dto.response;

import com.uisrael.hikvision.backend.dominio.enums.EstadoRegistro;
import com.uisrael.hikvision.backend.dominio.enums.TipoDispositivo;

import lombok.Data;

@Data
public class DispositivoResponseDTO {

    private Long id;
    private String codigo;
    private String ip;
    private Integer puerto;
    private String modelo;
    private String ubicacion;
    private EstadoRegistro estado;

    // Campos para conexion con Hikvision
    private String usuarioDispositivo;
    // Nota: No exponemos contrasena en el response por seguridad
    private String macAddress;
    private String numeroSerie;
    private TipoDispositivo tipoDispositivo;
    private String firmwareVersion;
    private Boolean habilitado;

    // Relacion con Piso
    private Long pisoId;
}
