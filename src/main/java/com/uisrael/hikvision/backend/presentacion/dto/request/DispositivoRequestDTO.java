package com.uisrael.hikvision.backend.presentacion.dto.request;

import com.uisrael.hikvision.backend.dominio.enums.EstadoRegistro;
import com.uisrael.hikvision.backend.dominio.enums.TipoDispositivo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DispositivoRequestDTO {

    @NotBlank
    private String codigo;

    @NotBlank
    private String ip;

    @NotNull
    private Integer puerto;

    private String modelo;

    private String ubicacion;

    @NotNull
    private EstadoRegistro estado;

    // Campos para conexion con Hikvision
    private String usuarioDispositivo;

    private String contrasenaDispositivo;

    private String macAddress;

    private String numeroSerie;

    private TipoDispositivo tipoDispositivo;

    private String firmwareVersion;

    private Boolean habilitado;

    // Relacion con Piso
    private Long pisoId;
}
