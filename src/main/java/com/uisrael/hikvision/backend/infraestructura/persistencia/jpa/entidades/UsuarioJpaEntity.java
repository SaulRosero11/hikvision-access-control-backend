package com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.entidades;

import com.uisrael.hikvision.backend.dominio.enums.EstadoRegistro;
import com.uisrael.hikvision.backend.dominio.enums.Genero;
import com.uisrael.hikvision.backend.dominio.enums.TipoUsuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios")
public class UsuarioJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long id;

    @Column(name = "identificacion", length = 50, nullable = true)
    private String identificacion;

    @Column(name = "nombre_completo", length = 150, nullable = false)
    private String nombreCompleto;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario", length = 30, nullable = false)
    private TipoUsuario tipoUsuario;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", length = 30, nullable = false)
    private EstadoRegistro estado;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;

    // Campos basados en formato Hikvision
    @Enumerated(EnumType.STRING)
    @Column(name = "genero", length = 20)
    private Genero genero;

    @Column(name = "numero_habitacion")
    private Integer numeroHabitacion;

    @Column(name = "numero_piso")
    private Integer numeroPiso;

    @Column(name = "derecho_puerta", length = 50)
    private String derechoPuerta;

    @Column(name = "derecho_ui_local")
    private Boolean derechoUILocal;

    // Validez embebida
    @Embedded
    private ValidezAccesoEmbeddable validez;

    // Relaciones
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @Builder.Default
    private List<PlanAccesoJpaEntity> planesAcceso = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @Builder.Default
    private List<ImagenUsuarioJpaEntity> imagenes = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @Builder.Default
    private List<UsuarioPisoPermisoJpaEntity> permisosPisos = new ArrayList<>();

    // Metodos helper para manejar las relaciones bidireccionales
    public void agregarPlanAcceso(PlanAccesoJpaEntity plan) {
        planesAcceso.add(plan);
        plan.setUsuario(this);
    }

    public void removerPlanAcceso(PlanAccesoJpaEntity plan) {
        planesAcceso.remove(plan);
        plan.setUsuario(null);
    }

    public void agregarImagen(ImagenUsuarioJpaEntity imagen) {
        imagenes.add(imagen);
        imagen.setUsuario(this);
    }

    public void removerImagen(ImagenUsuarioJpaEntity imagen) {
        imagenes.remove(imagen);
        imagen.setUsuario(null);
    }

    public void agregarPermisoPiso(UsuarioPisoPermisoJpaEntity permiso) {
        permisosPisos.add(permiso);
        permiso.setUsuario(this);
    }

    public void removerPermisoPiso(UsuarioPisoPermisoJpaEntity permiso) {
        permisosPisos.remove(permiso);
        permiso.setUsuario(null);
    }
}
