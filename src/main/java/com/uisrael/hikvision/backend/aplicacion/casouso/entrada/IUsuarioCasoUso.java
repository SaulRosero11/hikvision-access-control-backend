package com.uisrael.hikvision.backend.aplicacion.casouso.entrada;

import java.util.List;
import java.util.Optional;

import com.uisrael.hikvision.backend.dominio.entidades.Usuario;

public interface IUsuarioCasoUso {
  Usuario guardar(Usuario usuario);

  Optional<Usuario> buscarPorId(Long id);

  Optional<Usuario> buscarPorIdentificacion(String identificacion);

  List<Usuario> listar();

  void eliminarPorId(Long id);

  Usuario actualizar(Long id, Usuario usuario);
}
