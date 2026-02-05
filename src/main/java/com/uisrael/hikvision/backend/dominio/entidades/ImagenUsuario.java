package com.uisrael.hikvision.backend.dominio.entidades;

import com.uisrael.hikvision.backend.dominio.excepciones.DominioException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ImagenUsuario {
    private final Long id;
    private final String imagenBase64;
    private final String tipoImagen;
    private final Long usuarioId;

    public void validar() {
        if (imagenBase64 == null || imagenBase64.trim().isEmpty()) {
            throw new DominioException("La imagen en base64 es obligatoria.");
        }
    }
}
