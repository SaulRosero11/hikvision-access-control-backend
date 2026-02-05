package com.uisrael.hikvision.backend.dominio.entidades;

import com.uisrael.hikvision.backend.dominio.enums.EstadoRegistro;
import com.uisrael.hikvision.backend.dominio.excepciones.DominioException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Piso {
    private final Long id;
    private final Integer numeroPiso;
    private final String nombre;
    private final String descripcion;
    private final EstadoRegistro estado;
    private final Long edificioId;

    public void validar() {
        if (numeroPiso == null) {
            throw new DominioException("El numero de piso es obligatorio.");
        }
        if (edificioId == null) {
            throw new DominioException("El edificio es obligatorio.");
        }
        if (estado == null) {
            throw new DominioException("El estado del piso es obligatorio.");
        }
    }
}
