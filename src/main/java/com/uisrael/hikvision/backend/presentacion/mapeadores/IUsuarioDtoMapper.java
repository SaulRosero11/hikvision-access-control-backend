package com.uisrael.hikvision.backend.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.hikvision.backend.dominio.entidades.ImagenUsuario;
import com.uisrael.hikvision.backend.dominio.entidades.PlanAcceso;
import com.uisrael.hikvision.backend.dominio.entidades.Usuario;
import com.uisrael.hikvision.backend.dominio.entidades.ValidezAcceso;
import com.uisrael.hikvision.backend.presentacion.dto.request.ImagenUsuarioRequestDTO;
import com.uisrael.hikvision.backend.presentacion.dto.request.PlanAccesoRequestDTO;
import com.uisrael.hikvision.backend.presentacion.dto.request.UsuarioRequestDTO;
import com.uisrael.hikvision.backend.presentacion.dto.request.ValidezAccesoDTO;
import com.uisrael.hikvision.backend.presentacion.dto.response.ImagenUsuarioResponseDTO;
import com.uisrael.hikvision.backend.presentacion.dto.response.PlanAccesoResponseDTO;
import com.uisrael.hikvision.backend.presentacion.dto.response.UsuarioResponseDTO;
import com.uisrael.hikvision.backend.presentacion.dto.response.ValidezAccesoResponseDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IUsuarioDtoMapper {

    @Mapping(target = "id", ignore = true)
    Usuario toDomain(UsuarioRequestDTO dto);

    UsuarioResponseDTO toResponseDto(Usuario usuario);

    // Mappers para ValidezAcceso
    ValidezAcceso toDomain(ValidezAccesoDTO dto);
    ValidezAccesoResponseDTO toResponseDto(ValidezAcceso validez);

    // Mappers para PlanAcceso
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "usuarioId", ignore = true)
    PlanAcceso toDomain(PlanAccesoRequestDTO dto);
    PlanAccesoResponseDTO toResponseDto(PlanAcceso planAcceso);
    List<PlanAcceso> toPlanAccesoDomainList(List<PlanAccesoRequestDTO> dtos);
    List<PlanAccesoResponseDTO> toPlanAccesoResponseDtoList(List<PlanAcceso> planes);

    // Mappers para ImagenUsuario
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "usuarioId", ignore = true)
    ImagenUsuario toDomain(ImagenUsuarioRequestDTO dto);
    ImagenUsuarioResponseDTO toResponseDto(ImagenUsuario imagen);
    List<ImagenUsuario> toImagenUsuarioDomainList(List<ImagenUsuarioRequestDTO> dtos);
    List<ImagenUsuarioResponseDTO> toImagenUsuarioResponseDtoList(List<ImagenUsuario> imagenes);
}
