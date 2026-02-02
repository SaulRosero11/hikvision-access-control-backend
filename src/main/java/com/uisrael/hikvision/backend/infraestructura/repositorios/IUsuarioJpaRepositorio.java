package com.uisrael.hikvision.backend.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.entidades.UsuarioJpaEntity;

public interface IUsuarioJpaRepositorio extends JpaRepository<UsuarioJpaEntity, Integer> {

}
