package com.uisrael.hikvision.backend.presentacion.controladores;

import com.uisrael.hikvision.backend.aplicacion.casouso.entrada.IUsuarioPisoPermisoCasoUso;
import com.uisrael.hikvision.backend.presentacion.dto.request.UsuarioPisoPermisoRequestDTO;
import com.uisrael.hikvision.backend.presentacion.dto.response.UsuarioPisoPermisoResponseDTO;
import com.uisrael.hikvision.backend.presentacion.mapeadores.IUsuarioPisoPermisoDtoMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permiso-piso")
public class UsuarioPisoPermisoControlador {

    private final IUsuarioPisoPermisoCasoUso permisoCasoUso;
    private final IUsuarioPisoPermisoDtoMapper mapper;

    public UsuarioPisoPermisoControlador(IUsuarioPisoPermisoCasoUso permisoCasoUso, IUsuarioPisoPermisoDtoMapper mapper) {
        this.permisoCasoUso = permisoCasoUso;
        this.mapper = mapper;
    }

    @GetMapping
    public List<UsuarioPisoPermisoResponseDTO> listar() {
        return permisoCasoUso.listar().stream().map(mapper::toResponseDto).toList();
    }

    @GetMapping("/{id}")
    public UsuarioPisoPermisoResponseDTO buscarPorId(@PathVariable Long id) {
        return permisoCasoUso.buscarPorId(id)
                .map(mapper::toResponseDto)
                .orElseThrow(() -> new EntityNotFoundException("Permiso no encontrado con id: " + id));
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<UsuarioPisoPermisoResponseDTO> listarPorUsuario(@PathVariable Long usuarioId) {
        return permisoCasoUso.listarPorUsuarioId(usuarioId).stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    @GetMapping("/piso/{pisoId}")
    public List<UsuarioPisoPermisoResponseDTO> listarPorPiso(@PathVariable Long pisoId) {
        return permisoCasoUso.listarPorPisoId(pisoId).stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    @GetMapping("/usuario/{usuarioId}/piso/{pisoId}")
    public UsuarioPisoPermisoResponseDTO buscarPorUsuarioYPiso(@PathVariable Long usuarioId, @PathVariable Long pisoId) {
        return permisoCasoUso.buscarPorUsuarioYPiso(usuarioId, pisoId)
                .map(mapper::toResponseDto)
                .orElseThrow(() -> new EntityNotFoundException("Permiso no encontrado para usuario: " + usuarioId + " y piso: " + pisoId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioPisoPermisoResponseDTO guardar(@Valid @RequestBody UsuarioPisoPermisoRequestDTO request) {
        return mapper.toResponseDto(permisoCasoUso.guardar(mapper.toDomain(request)));
    }

    @PutMapping("/{id}")
    public UsuarioPisoPermisoResponseDTO actualizar(@PathVariable Long id, @Valid @RequestBody UsuarioPisoPermisoRequestDTO request) {
        return mapper.toResponseDto(permisoCasoUso.actualizar(id, mapper.toDomain(request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        permisoCasoUso.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
