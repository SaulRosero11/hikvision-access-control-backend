package com.uisrael.hikvision.backend.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.hikvision.backend.dominio.entidades.Usuario;
import com.uisrael.hikvision.backend.presentacion.dto.request.UsuarioRequestDTO;
import com.uisrael.hikvision.backend.presentacion.dto.response.UsuarioResponseDTO;

@Mapper(componentModel= "spring")
public interface IUsuarioDtoMapper {

  Usuario toDomain(UsuarioRequestDTO dto);

  UsuarioResponseDTO toResponseDto(Usuario usuario);

}
