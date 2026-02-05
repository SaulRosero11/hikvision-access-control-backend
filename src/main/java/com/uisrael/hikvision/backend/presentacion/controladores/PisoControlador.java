package com.uisrael.hikvision.backend.presentacion.controladores;

import com.uisrael.hikvision.backend.aplicacion.casouso.entrada.IPisoCasoUso;
import com.uisrael.hikvision.backend.presentacion.dto.request.PisoRequestDTO;
import com.uisrael.hikvision.backend.presentacion.dto.response.PisoResponseDTO;
import com.uisrael.hikvision.backend.presentacion.mapeadores.IPisoDtoMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/piso")
public class PisoControlador {

    private final IPisoCasoUso pisoCasoUso;
    private final IPisoDtoMapper mapper;

    public PisoControlador(IPisoCasoUso pisoCasoUso, IPisoDtoMapper mapper) {
        this.pisoCasoUso = pisoCasoUso;
        this.mapper = mapper;
    }

    @GetMapping
    public List<PisoResponseDTO> listar() {
        return pisoCasoUso.listar().stream().map(mapper::toResponseDto).toList();
    }

    @GetMapping("/{id}")
    public PisoResponseDTO buscarPorId(@PathVariable Long id) {
        return pisoCasoUso.buscarPorId(id)
                .map(mapper::toResponseDto)
                .orElseThrow(() -> new EntityNotFoundException("Piso no encontrado con id: " + id));
    }

    @GetMapping("/edificio/{edificioId}")
    public List<PisoResponseDTO> listarPorEdificio(@PathVariable Long edificioId) {
        return pisoCasoUso.listarPorEdificioId(edificioId).stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PisoResponseDTO guardar(@Valid @RequestBody PisoRequestDTO request) {
        return mapper.toResponseDto(pisoCasoUso.guardar(mapper.toDomain(request)));
    }

    @PutMapping("/{id}")
    public PisoResponseDTO actualizar(@PathVariable Long id, @Valid @RequestBody PisoRequestDTO request) {
        return mapper.toResponseDto(pisoCasoUso.actualizar(id, mapper.toDomain(request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        pisoCasoUso.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
