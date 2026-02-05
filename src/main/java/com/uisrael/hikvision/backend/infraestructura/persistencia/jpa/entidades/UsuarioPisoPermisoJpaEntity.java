package com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.entidades;

import com.uisrael.hikvision.backend.dominio.enums.EstadoRegistro;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios_pisos_permisos",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_usuario_piso", columnNames = {"usuario_id", "piso_id"})
        },
        indexes = {
                @Index(name = "idx_permiso_usuario", columnList = "usuario_id"),
                @Index(name = "idx_permiso_piso", columnList = "piso_id")
        })
public class UsuarioPisoPermisoJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permiso_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_permiso_usuario"))
    private UsuarioJpaEntity usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "piso_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_permiso_piso"))
    private PisoJpaEntity piso;

    @Column(name = "acceso_permitido", nullable = false)
    private Boolean accesoPermitido;

    @Column(name = "fecha_asignacion", nullable = false)
    private LocalDateTime fechaAsignacion;

    @Column(name = "fecha_expiracion")
    private LocalDateTime fechaExpiracion;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", length = 30, nullable = false)
    private EstadoRegistro estado;

    @Column(name = "observaciones", length = 500)
    private String observaciones;
}
