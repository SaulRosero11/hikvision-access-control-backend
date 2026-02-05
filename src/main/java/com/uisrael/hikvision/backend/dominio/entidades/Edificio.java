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
public class Edificio {
    private final Long id;
    private final String codigo;
    private final String nombre;
    private final String direccion;
    private final Integer numeroPisos;
    private final String descripcion;
    private final String telefono;
    private final String email;
    private final EstadoRegistro estado;
    private final LocalDateTime fechaCreacion;

    public void validar() {
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new DominioException("El codigo del edificio es obligatorio.");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new DominioException("El nombre del edificio es obligatorio.");
        }
        if (numeroPisos == null || numeroPisos < 1) {
            throw new DominioException("El numero de pisos debe ser mayor a 0.");
        }
        if (estado == null) {
            throw new DominioException("El estado del edificio es obligatorio.");
        }
    }
}
