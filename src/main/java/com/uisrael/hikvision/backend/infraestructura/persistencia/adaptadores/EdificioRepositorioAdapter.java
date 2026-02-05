package com.uisrael.hikvision.backend.infraestructura.persistencia.adaptadores;

import com.uisrael.hikvision.backend.dominio.entidades.Edificio;
import com.uisrael.hikvision.backend.dominio.puertos.repositorio.EdificioRepositorioPort;
import com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.repositorios.EdificioJpaRepository;
import com.uisrael.hikvision.backend.infraestructura.persistencia.mapeadores.EdificioJpaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EdificioRepositorioAdapter implements EdificioRepositorioPort {

    private final EdificioJpaRepository edificioJpaRepository;
    private final EdificioJpaMapper mapper = new EdificioJpaMapper();

    @Override
    public Edificio guardar(Edificio edificio) {
        var entidad = mapper.aJpa(edificio);
        var guardado = edificioJpaRepository.save(entidad);
        return mapper.aDominio(guardado);
    }

    @Override
    public Optional<Edificio> buscarPorId(Long id) {
        return edificioJpaRepository.findById(id).map(mapper::aDominio);
    }

    @Override
    public Optional<Edificio> buscarPorCodigo(String codigo) {
        return edificioJpaRepository.findByCodigo(codigo).map(mapper::aDominio);
    }

    @Override
    public List<Edificio> listar() {
        return edificioJpaRepository.findAll().stream().map(mapper::aDominio).toList();
    }

    @Override
    public void eliminarPorId(Long id) {
        edificioJpaRepository.deleteById(id);
    }

    @Override
    public boolean existePorId(Long id) {
        return edificioJpaRepository.existsById(id);
    }
}
