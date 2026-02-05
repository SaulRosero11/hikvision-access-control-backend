package com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.entidades;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "planes_acceso")
public class PlanAccesoJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plan_acceso_id")
    private Long id;

    @Column(name = "numero_puerta", nullable = false)
    private Integer numeroPuerta;

    @Column(name = "numero_plantilla", length = 50, nullable = false)
    private String numeroPlantilla;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_plan_acceso_usuario"))
    private UsuarioJpaEntity usuario;
}
