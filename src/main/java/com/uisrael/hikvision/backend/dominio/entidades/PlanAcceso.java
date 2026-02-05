package com.uisrael.hikvision.backend.dominio.entidades;

import com.uisrael.hikvision.backend.dominio.excepciones.DominioException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class PlanAcceso {
    private final Long id;
    private final Integer numeroPuerta;
    private final String numeroPlantilla;
    private final Long usuarioId;

    public void validar() {
        if (numeroPuerta == null || numeroPuerta < 1) {
            throw new DominioException("El numero de puerta debe ser mayor a 0.");
        }
        if (numeroPlantilla == null || numeroPlantilla.trim().isEmpty()) {
            throw new DominioException("El numero de plantilla es obligatorio.");
        }
    }
}
