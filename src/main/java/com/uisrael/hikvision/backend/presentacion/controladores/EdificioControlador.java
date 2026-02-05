package com.uisrael.hikvision.backend.presentacion.controladores;

import com.uisrael.hikvision.backend.aplicacion.casouso.entrada.IEdificioCasoUso;
import com.uisrael.hikvision.backend.presentacion.dto.request.EdificioRequestDTO;
import com.uisrael.hikvision.backend.presentacion.dto.response.EdificioResponseDTO;
import com.uisrael.hikvision.backend.presentacion.mapeadores.IEdificioDtoMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/edificio")
public class EdificioControlador {

    private final IEdificioCasoUso edificioCasoUso;
    private final IEdificioDtoMapper mapper;

    public EdificioControlador(IEdificioCasoUso edificioCasoUso, IEdificioDtoMapper mapper) {
        this.edificioCasoUso = edificioCasoUso;
        this.mapper = mapper;
    }

    @GetMapping
    public List<EdificioResponseDTO> listar() {
        return edificioCasoUso.listar().stream().map(mapper::toResponseDto).toList();
    }

    @GetMapping("/{id}")
    public EdificioResponseDTO buscarPorId(@PathVariable Long id) {
        return edificioCasoUso.buscarPorId(id)
                .map(mapper::toResponseDto)
                .orElseThrow(() -> new EntityNotFoundException("Edificio no encontrado con id: " + id));
    }

    @GetMapping("/codigo/{codigo}")
    public EdificioResponseDTO buscarPorCodigo(@PathVariable String codigo) {
        return edificioCasoUso.buscarPorCodigo(codigo)
                .map(mapper::toResponseDto)
                .orElseThrow(() -> new EntityNotFoundException("Edificio no encontrado con codigo: " + codigo));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EdificioResponseDTO guardar(@Valid @RequestBody EdificioRequestDTO request) {
        return mapper.toResponseDto(edificioCasoUso.guardar(mapper.toDomain(request)));
    }

    @PutMapping("/{id}")
    public EdificioResponseDTO actualizar(@PathVariable Long id, @Valid @RequestBody EdificioRequestDTO request) {
        return mapper.toResponseDto(edificioCasoUso.actualizar(id, mapper.toDomain(request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        edificioCasoUso.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
