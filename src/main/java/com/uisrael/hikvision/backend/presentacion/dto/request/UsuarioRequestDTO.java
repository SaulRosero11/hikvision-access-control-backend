package com.uisrael.hikvision.backend.presentacion.dto.request;

import java.time.LocalDateTime;
import java.util.List;

import com.uisrael.hikvision.backend.dominio.enums.EstadoRegistro;
import com.uisrael.hikvision.backend.dominio.enums.Genero;
import com.uisrael.hikvision.backend.dominio.enums.TipoUsuario;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UsuarioRequestDTO {

    @NotBlank
    private String identificacion;

    @NotBlank
    private String nombreCompleto;

    @NotNull
    private TipoUsuario tipoUsuario;

    @NotNull
    private EstadoRegistro estado;

    @NotNull
    private LocalDateTime fechaRegistro;

    // Nuevos campos basados en formato Hikvision
    private Genero genero;
    private Integer numeroHabitacion;
    private Integer numeroPiso;
    private String derechoPuerta;
    private Boolean derechoUILocal;

    @Valid
    private ValidezAccesoDTO validez;

    @Valid
    private List<PlanAccesoRequestDTO> planesAcceso;

    @Valid
    private List<ImagenUsuarioRequestDTO> imagenes;
}
