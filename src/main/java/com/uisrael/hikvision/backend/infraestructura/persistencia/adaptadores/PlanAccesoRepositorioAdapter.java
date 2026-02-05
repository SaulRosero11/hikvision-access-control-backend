package com.uisrael.hikvision.backend.infraestructura.persistencia.adaptadores;

import com.uisrael.hikvision.backend.dominio.entidades.PlanAcceso;
import com.uisrael.hikvision.backend.dominio.puertos.repositorio.PlanAccesoRepositorioPort;
import com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.repositorios.PlanAccesoJpaRepository;
import com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.repositorios.UsuarioJpaRepository;
import com.uisrael.hikvision.backend.infraestructura.persistencia.mapeadores.PlanAccesoJpaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PlanAccesoRepositorioAdapter implements PlanAccesoRepositorioPort {

    private final PlanAccesoJpaRepository planAccesoJpaRepository;
    private final UsuarioJpaRepository usuarioJpaRepository;
    private final PlanAccesoJpaMapper mapper = new PlanAccesoJpaMapper();

    @Override
    public PlanAcceso guardar(PlanAcceso planAcceso) {
        var usuarioJpa = usuarioJpaRepository.findById(planAcceso.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        var entidad = mapper.aJpa(planAcceso, usuarioJpa);
        var guardado = planAccesoJpaRepository.save(entidad);
        return mapper.aDominio(guardado);
    }

    @Override
    public Optional<PlanAcceso> buscarPorId(Long id) {
        return planAccesoJpaRepository.findById(id).map(mapper::aDominio);
    }

    @Override
    public List<PlanAcceso> listarPorUsuarioId(Long usuarioId) {
        return planAccesoJpaRepository.findByUsuario_Id(usuarioId)
                .stream()
                .map(mapper::aDominio)
                .toList();
    }

    @Override
    public void eliminarPorId(Long id) {
        planAccesoJpaRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void eliminarPorUsuarioId(Long usuarioId) {
        planAccesoJpaRepository.deleteByUsuario_Id(usuarioId);
    }
}
