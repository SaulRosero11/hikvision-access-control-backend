package com.uisrael.hikvision.backend.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.entidades.DispositivoJpaEntity;

public interface IDispositivoJpaRepositorio extends JpaRepository<DispositivoJpaEntity, Integer> {

}
