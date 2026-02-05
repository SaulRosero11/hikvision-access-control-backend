package com.uisrael.hikvision.backend.dominio.entidades;

import com.uisrael.hikvision.backend.dominio.enums.EstadoRegistro;
import com.uisrael.hikvision.backend.dominio.excepciones.DominioException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class UsuarioPisoPermiso {
    private final Long id;
    private final Long usuarioId;
    private final Long pisoId;
    private final Boolean accesoPermitido;
    private final LocalDateTime fechaAsignacion;
    private final LocalDateTime fechaExpiracion;
    private final EstadoRegistro estado;
    private final String observaciones;

    public void validar() {
        if (usuarioId == null) {
            throw new DominioException("El usuario es obligatorio.");
        }
        if (pisoId == null) {
            throw new DominioException("El piso es obligatorio.");
        }
        if (estado == null) {
            throw new DominioException("El estado del permiso es obligatorio.");
        }
    }
}
