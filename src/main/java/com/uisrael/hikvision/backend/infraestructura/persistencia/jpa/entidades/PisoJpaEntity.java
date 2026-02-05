package com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.entidades;

import com.uisrael.hikvision.backend.dominio.enums.EstadoRegistro;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pisos",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_piso_edificio_numero", columnNames = {"edificio_id", "numero_piso"})
        },
        indexes = {
                @Index(name = "idx_piso_edificio", columnList = "edificio_id")
        })
public class PisoJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "piso_id")
    private Long id;

    @Column(name = "numero_piso", nullable = false)
    private Integer numeroPiso;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "descripcion", length = 255)
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", length = 30, nullable = false)
    private EstadoRegistro estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "edificio_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_piso_edificio"))
    private EdificioJpaEntity edificio;

    @OneToMany(mappedBy = "piso", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private List<DispositivoJpaEntity> dispositivos = new ArrayList<>();
}
