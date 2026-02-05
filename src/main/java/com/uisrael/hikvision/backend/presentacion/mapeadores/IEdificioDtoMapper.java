package com.uisrael.hikvision.backend.presentacion.mapeadores;

import com.uisrael.hikvision.backend.dominio.entidades.Edificio;
import com.uisrael.hikvision.backend.presentacion.dto.request.EdificioRequestDTO;
import com.uisrael.hikvision.backend.presentacion.dto.response.EdificioResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IEdificioDtoMapper {

    @Mapping(target = "id", ignore = true)
    Edificio toDomain(EdificioRequestDTO dto);

    EdificioResponseDTO toResponseDto(Edificio edificio);
}
