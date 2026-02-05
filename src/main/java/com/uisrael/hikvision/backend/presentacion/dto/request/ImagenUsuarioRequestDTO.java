package com.uisrael.hikvision.backend.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ImagenUsuarioRequestDTO {
    @NotBlank
    private String imagenBase64;

    private String tipoImagen;
}
