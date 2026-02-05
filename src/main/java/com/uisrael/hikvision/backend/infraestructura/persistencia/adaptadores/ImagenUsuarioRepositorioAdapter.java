package com.uisrael.hikvision.backend.infraestructura.persistencia.adaptadores;

import com.uisrael.hikvision.backend.dominio.entidades.ImagenUsuario;
import com.uisrael.hikvision.backend.dominio.puertos.repositorio.ImagenUsuarioRepositorioPort;
import com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.repositorios.ImagenUsuarioJpaRepository;
import com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.repositorios.UsuarioJpaRepository;
import com.uisrael.hikvision.backend.infraestructura.persistencia.mapeadores.ImagenUsuarioJpaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ImagenUsuarioRepositorioAdapter implements ImagenUsuarioRepositorioPort {

    private final ImagenUsuarioJpaRepository imagenUsuarioJpaRepository;
    private final UsuarioJpaRepository usuarioJpaRepository;
    private final ImagenUsuarioJpaMapper mapper = new ImagenUsuarioJpaMapper();

    @Override
    public ImagenUsuario guardar(ImagenUsuario imagenUsuario) {
        var usuarioJpa = usuarioJpaRepository.findById(imagenUsuario.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        var entidad = mapper.aJpa(imagenUsuario, usuarioJpa);
        var guardado = imagenUsuarioJpaRepository.save(entidad);
        return mapper.aDominio(guardado);
    }

    @Override
    public Optional<ImagenUsuario> buscarPorId(Long id) {
        return imagenUsuarioJpaRepository.findById(id).map(mapper::aDominio);
    }

    @Override
    public List<ImagenUsuario> listarPorUsuarioId(Long usuarioId) {
        return imagenUsuarioJpaRepository.findByUsuario_Id(usuarioId)
                .stream()
                .map(mapper::aDominio)
                .toList();
    }

    @Override
    public void eliminarPorId(Long id) {
        imagenUsuarioJpaRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void eliminarPorUsuarioId(Long usuarioId) {
        imagenUsuarioJpaRepository.deleteByUsuario_Id(usuarioId);
    }
}
