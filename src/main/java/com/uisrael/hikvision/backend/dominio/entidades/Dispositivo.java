package com.uisrael.hikvision.backend.dominio.entidades;

import com.uisrael.hikvision.backend.dominio.enums.EstadoRegistro;
import com.uisrael.hikvision.backend.dominio.enums.TipoDispositivo;
import com.uisrael.hikvision.backend.dominio.excepciones.DominioException;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
public class Dispositivo {
    private final Long id;
    private final String codigo;
    private final String ip;
    private final Integer puerto;
    private final String modelo;
    private final String ubicacion;
    private final EstadoRegistro estado;

    // Nuevos campos para conexion con Hikvision
    private final String usuarioDispositivo;
    private final String contrasenaDispositivo;
    private final String macAddress;
    private final String numeroSerie;
    private final TipoDispositivo tipoDispositivo;
    private final String firmwareVersion;
    private final Boolean habilitado;

    // Relacion con Piso
    private final Long pisoId;

    public void validar() {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new DominioException("El codigo del dispositivo es obligatorio.");
        }
        if (ip == null || ip.trim().isEmpty()) {
            throw new DominioException("La IP del dispositivo es obligatoria.");
        }
        if (puerto == null || puerto < 1 || puerto > 65535) {
            throw new DominioException("El puerto del dispositivo debe estar entre 1 y 65535.");
        }
        if (estado == null) {
            throw new DominioException("El estado del dispositivo es obligatorio.");
        }
    }
}
