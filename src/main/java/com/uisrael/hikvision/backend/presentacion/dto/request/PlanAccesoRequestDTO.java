package com.uisrael.hikvision.backend.presentacion.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PlanAccesoRequestDTO {
    @NotNull
    @Min(1)
    private Integer numeroPuerta;

    @NotBlank
    private String numeroPlantilla;
}
