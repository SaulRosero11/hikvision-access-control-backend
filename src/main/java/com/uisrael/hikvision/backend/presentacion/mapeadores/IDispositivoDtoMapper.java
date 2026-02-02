package com.uisrael.hikvision.backend.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.hikvision.backend.dominio.entidades.Dispositivo;
import com.uisrael.hikvision.backend.presentacion.dto.request.DispositivoRequestDTO;
import com.uisrael.hikvision.backend.presentacion.dto.response.DispositivoResponseDTO;

@Mapper(componentModel="spring")
public interface IDispositivoDtoMapper {

  Dispositivo toDomain(DispositivoRequestDTO dto);

  DispositivoResponseDTO toResponseDto(Dispositivo dispositivo);

}
