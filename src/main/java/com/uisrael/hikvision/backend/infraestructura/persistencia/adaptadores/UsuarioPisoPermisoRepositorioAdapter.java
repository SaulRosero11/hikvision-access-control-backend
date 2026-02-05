package com.uisrael.hikvision.backend.infraestructura.persistencia.adaptadores;

import com.uisrael.hikvision.backend.dominio.entidades.UsuarioPisoPermiso;
import com.uisrael.hikvision.backend.dominio.puertos.repositorio.UsuarioPisoPermisoRepositorioPort;
import com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.repositorios.PisoJpaRepository;
import com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.repositorios.UsuarioJpaRepository;
import com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.repositorios.UsuarioPisoPermisoJpaRepository;
import com.uisrael.hikvision.backend.infraestructura.persistencia.mapeadores.UsuarioPisoPermisoJpaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UsuarioPisoPermisoRepositorioAdapter implements UsuarioPisoPermisoRepositorioPort {

    private final UsuarioPisoPermisoJpaRepository permisoJpaRepository;
    private final UsuarioJpaRepository usuarioJpaRepository;
    private final PisoJpaRepository pisoJpaRepository;
    private final UsuarioPisoPermisoJpaMapper mapper = new UsuarioPisoPermisoJpaMapper();

    @Override
    public UsuarioPisoPermiso guardar(UsuarioPisoPermiso permiso) {
        var usuarioJpa = usuarioJpaRepository.findById(permiso.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        var pisoJpa = pisoJpaRepository.findById(permiso.getPisoId())
                .orElseThrow(() -> new RuntimeException("Piso no encontrado"));
        var entidad = mapper.aJpa(permiso, usuarioJpa, pisoJpa);
        var guardado = permisoJpaRepository.save(entidad);
        return mapper.aDominio(guardado);
    }

    @Override
    public Optional<UsuarioPisoPermiso> buscarPorId(Long id) {
        return permisoJpaRepository.findById(id).map(mapper::aDominio);
    }

    @Override
    public Optional<UsuarioPisoPermiso> buscarPorUsuarioYPiso(Long usuarioId, Long pisoId) {
        return permisoJpaRepository.findByUsuario_IdAndPiso_Id(usuarioId, pisoId).map(mapper::aDominio);
    }

    @Override
    public List<UsuarioPisoPermiso> listarPorUsuarioId(Long usuarioId) {
        return permisoJpaRepository.findByUsuario_Id(usuarioId).stream()
                .map(mapper::aDominio)
                .toList();
    }

    @Override
    public List<UsuarioPisoPermiso> listarPorPisoId(Long pisoId) {
        return permisoJpaRepository.findByPiso_Id(pisoId).stream()
                .map(mapper::aDominio)
                .toList();
    }

    @Override
    public List<UsuarioPisoPermiso> listar() {
        return permisoJpaRepository.findAll().stream().map(mapper::aDominio).toList();
    }

    @Override
    public void eliminarPorId(Long id) {
        permisoJpaRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void eliminarPorUsuarioId(Long usuarioId) {
        permisoJpaRepository.deleteByUsuario_Id(usuarioId);
    }

    @Override
    public boolean existePorId(Long id) {
        return permisoJpaRepository.existsById(id);
    }
}
