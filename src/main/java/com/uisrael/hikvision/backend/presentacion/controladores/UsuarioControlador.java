package com.uisrael.hikvision.backend.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.hikvision.backend.aplicacion.casouso.entrada.IUsuarioCasoUso;
import com.uisrael.hikvision.backend.presentacion.dto.request.UsuarioRequestDTO;
import com.uisrael.hikvision.backend.presentacion.dto.response.UsuarioResponseDTO;
import com.uisrael.hikvision.backend.presentacion.mapeadores.IUsuarioDtoMapper;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioControlador {

    private final IUsuarioCasoUso usuarioCasoUso;
    private final IUsuarioDtoMapper mapper;

    public UsuarioControlador(IUsuarioCasoUso usuarioCasoUso, IUsuarioDtoMapper mapper) {
        this.usuarioCasoUso = usuarioCasoUso;
        this.mapper = mapper;
    }

    @GetMapping
    public List<UsuarioResponseDTO> listar() {
        return usuarioCasoUso.listar().stream().map(mapper::toResponseDto).toList();
    }

    @GetMapping("/{id}")
    public UsuarioResponseDTO buscarPorId(@PathVariable Long id) {
        return usuarioCasoUso.buscarPorId(id)
                .map(mapper::toResponseDto)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con id: " + id));
    }

    @GetMapping("/identificacion/{identificacion}")
    public UsuarioResponseDTO buscarPorIdentificacion(@PathVariable String identificacion) {
        return usuarioCasoUso.buscarPorIdentificacion(identificacion)
                .map(mapper::toResponseDto)
                .orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado con identificacion: " + identificacion));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioResponseDTO guardar(@Valid @RequestBody UsuarioRequestDTO request) {
        return mapper.toResponseDto(usuarioCasoUso.guardar(mapper.toDomain(request)));
    }

    @PutMapping("/{id}")
    public UsuarioResponseDTO actualizar(@PathVariable Long id, @Valid @RequestBody UsuarioRequestDTO request) {
        return mapper.toResponseDto(usuarioCasoUso.actualizar(id, mapper.toDomain(request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        usuarioCasoUso.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
