package com.uisrael.hikvision.backend.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.hikvision.backend.dominio.entidades.Dispositivo;
import com.uisrael.hikvision.backend.presentacion.dto.request.DispositivoRequestDTO;
import com.uisrael.hikvision.backend.presentacion.dto.response.DispositivoResponseDTO;

@Mapper(componentModel = "spring")
public interface IDispositivoDtoMapper {

    @Mapping(target = "id", ignore = true)
    Dispositivo toDomain(DispositivoRequestDTO dto);

    DispositivoResponseDTO toResponseDto(Dispositivo dispositivo);
}
