package com.uisrael.hikvision.backend.presentacion.mapeadores;

import com.uisrael.hikvision.backend.dominio.entidades.Piso;
import com.uisrael.hikvision.backend.presentacion.dto.request.PisoRequestDTO;
import com.uisrael.hikvision.backend.presentacion.dto.response.PisoResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IPisoDtoMapper {

    @Mapping(target = "id", ignore = true)
    Piso toDomain(PisoRequestDTO dto);

    PisoResponseDTO toResponseDto(Piso piso);
}
