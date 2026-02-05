package com.uisrael.hikvision.backend.presentacion.mapeadores;

import com.uisrael.hikvision.backend.dominio.entidades.UsuarioPisoPermiso;
import com.uisrael.hikvision.backend.presentacion.dto.request.UsuarioPisoPermisoRequestDTO;
import com.uisrael.hikvision.backend.presentacion.dto.response.UsuarioPisoPermisoResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IUsuarioPisoPermisoDtoMapper {

    @Mapping(target = "id", ignore = true)
    UsuarioPisoPermiso toDomain(UsuarioPisoPermisoRequestDTO dto);

    UsuarioPisoPermisoResponseDTO toResponseDto(UsuarioPisoPermiso permiso);
}
