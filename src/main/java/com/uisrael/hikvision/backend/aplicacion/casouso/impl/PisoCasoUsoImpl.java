package com.uisrael.hikvision.backend.aplicacion.casouso.impl;

import com.uisrael.hikvision.backend.aplicacion.casouso.entrada.IPisoCasoUso;
import com.uisrael.hikvision.backend.dominio.entidades.Piso;
import com.uisrael.hikvision.backend.dominio.puertos.repositorio.PisoRepositorioPort;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PisoCasoUsoImpl implements IPisoCasoUso {

    private final PisoRepositorioPort repositorio;

    public PisoCasoUsoImpl(PisoRepositorioPort repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Piso guardar(Piso piso) {
        return repositorio.guardar(piso);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Piso> buscarPorId(Long id) {
        return repositorio.buscarPorId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Piso> listarPorEdificioId(Long edificioId) {
        return repositorio.listarPorEdificioId(edificioId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Piso> listar() {
        return repositorio.listar();
    }

    @Override
    public void eliminarPorId(Long id) {
        repositorio.eliminarPorId(id);
    }

    @Override
    public Piso actualizar(Long id, Piso piso) {
        if (!repositorio.existePorId(id)) {
            throw new EntityNotFoundException("Piso no encontrado con id: " + id);
        }
        Piso pisoActualizado = Piso.builder()
                .id(id)
                .numeroPiso(piso.getNumeroPiso())
                .nombre(piso.getNombre())
                .descripcion(piso.getDescripcion())
                .estado(piso.getEstado())
                .edificioId(piso.getEdificioId())
                .build();
        return repositorio.guardar(pisoActualizado);
    }
}
