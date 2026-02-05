package com.uisrael.hikvision.backend.dominio.entidades;

import com.uisrael.hikvision.backend.dominio.enums.EstadoRegistro;
import com.uisrael.hikvision.backend.dominio.enums.Genero;
import com.uisrael.hikvision.backend.dominio.enums.TipoUsuario;
import com.uisrael.hikvision.backend.dominio.excepciones.DominioException;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class Usuario {
    private final Long id;
    private final String identificacion;
    private final String nombreCompleto;
    private final TipoUsuario tipoUsuario;
    private final EstadoRegistro estado;
    private final LocalDateTime fechaRegistro;

    // Campos basados en formato Hikvision
    private final Genero genero;
    private final Integer numeroHabitacion;
    private final Integer numeroPiso;
    private final String derechoPuerta;
    private final Boolean derechoUILocal;
    private final ValidezAcceso validez;

    // Relaciones
    private final List<PlanAcceso> planesAcceso;
    private final List<ImagenUsuario> imagenes;
    private final List<UsuarioPisoPermiso> permisospisos;

    public void validar() {
        if (nombreCompleto == null || nombreCompleto.trim().isEmpty()) {
            throw new DominioException("El nombre completo del usuario es obligatorio.");
        }
        if (tipoUsuario == null) {
            throw new DominioException("El tipo de usuario es obligatorio.");
        }
        if (estado == null) {
            throw new DominioException("El estado del usuario es obligatorio.");
        }
    }
}
