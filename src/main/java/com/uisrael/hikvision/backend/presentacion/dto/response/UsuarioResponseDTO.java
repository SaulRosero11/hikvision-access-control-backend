package com.uisrael.hikvision.backend.presentacion.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import com.uisrael.hikvision.backend.dominio.enums.EstadoRegistro;
import com.uisrael.hikvision.backend.dominio.enums.Genero;
import com.uisrael.hikvision.backend.dominio.enums.TipoUsuario;

import lombok.Data;

@Data
public class UsuarioResponseDTO {
    private Long id;
    private String identificacion;
    private String nombreCompleto;
    private TipoUsuario tipoUsuario;
    private EstadoRegistro estado;
    private LocalDateTime fechaRegistro;

    // Nuevos campos basados en formato Hikvision
    private Genero genero;
    private Integer numeroHabitacion;
    private Integer numeroPiso;
    private String derechoPuerta;
    private Boolean derechoUILocal;

    private ValidezAccesoResponseDTO validez;
    private List<PlanAccesoResponseDTO> planesAcceso;
    private List<ImagenUsuarioResponseDTO> imagenes;
}
