package com.uisrael.hikvision.backend.presentacion.dto.response;

import lombok.Data;

@Data
public class ImagenUsuarioResponseDTO {
    private Long id;
    private String imagenBase64;
    private String tipoImagen;
}
