package com.uisrael.hikvision.backend.aplicacion.casouso.impl;

import com.uisrael.hikvision.backend.aplicacion.casouso.entrada.IEdificioCasoUso;
import com.uisrael.hikvision.backend.dominio.entidades.Edificio;
import com.uisrael.hikvision.backend.dominio.puertos.repositorio.EdificioRepositorioPort;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EdificioCasoUsoImpl implements IEdificioCasoUso {

    private final EdificioRepositorioPort repositorio;

    public EdificioCasoUsoImpl(EdificioRepositorioPort repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Edificio guardar(Edificio edificio) {
        return repositorio.guardar(edificio);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Edificio> buscarPorId(Long id) {
        return repositorio.buscarPorId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Edificio> buscarPorCodigo(String codigo) {
        return repositorio.buscarPorCodigo(codigo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Edificio> listar() {
        return repositorio.listar();
    }

    @Override
    public void eliminarPorId(Long id) {
        repositorio.eliminarPorId(id);
    }

    @Override
    public Edificio actualizar(Long id, Edificio edificio) {
        if (!repositorio.existePorId(id)) {
            throw new EntityNotFoundException("Edificio no encontrado con id: " + id);
        }
        Edificio edificioActualizado = Edificio.builder()
                .id(id)
                .codigo(edificio.getCodigo())
                .nombre(edificio.getNombre())
                .direccion(edificio.getDireccion())
                .numeroPisos(edificio.getNumeroPisos())
                .descripcion(edificio.getDescripcion())
                .telefono(edificio.getTelefono())
                .email(edificio.getEmail())
                .estado(edificio.getEstado())
                .fechaCreacion(edificio.getFechaCreacion())
                .build();
        return repositorio.guardar(edificioActualizado);
    }
}
