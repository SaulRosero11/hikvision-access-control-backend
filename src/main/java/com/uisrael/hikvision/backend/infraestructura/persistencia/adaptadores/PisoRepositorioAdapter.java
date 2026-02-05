package com.uisrael.hikvision.backend.infraestructura.persistencia.adaptadores;

import com.uisrael.hikvision.backend.dominio.entidades.Piso;
import com.uisrael.hikvision.backend.dominio.puertos.repositorio.PisoRepositorioPort;
import com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.repositorios.EdificioJpaRepository;
import com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.repositorios.PisoJpaRepository;
import com.uisrael.hikvision.backend.infraestructura.persistencia.mapeadores.PisoJpaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PisoRepositorioAdapter implements PisoRepositorioPort {

    private final PisoJpaRepository pisoJpaRepository;
    private final EdificioJpaRepository edificioJpaRepository;
    private final PisoJpaMapper mapper = new PisoJpaMapper();

    @Override
    public Piso guardar(Piso piso) {
        var edificioJpa = edificioJpaRepository.findById(piso.getEdificioId())
                .orElseThrow(() -> new RuntimeException("Edificio no encontrado"));
        var entidad = mapper.aJpa(piso, edificioJpa);
        var guardado = pisoJpaRepository.save(entidad);
        return mapper.aDominio(guardado);
    }

    @Override
    public Optional<Piso> buscarPorId(Long id) {
        return pisoJpaRepository.findById(id).map(mapper::aDominio);
    }

    @Override
    public List<Piso> listarPorEdificioId(Long edificioId) {
        return pisoJpaRepository.findByEdificio_Id(edificioId).stream()
                .map(mapper::aDominio)
                .toList();
    }

    @Override
    public List<Piso> listar() {
        return pisoJpaRepository.findAll().stream().map(mapper::aDominio).toList();
    }

    @Override
    public void eliminarPorId(Long id) {
        pisoJpaRepository.deleteById(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return pisoJpaRepository.existsById(id);
    }
}
