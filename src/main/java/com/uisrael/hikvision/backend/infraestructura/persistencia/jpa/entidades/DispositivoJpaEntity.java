package com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.entidades;

import com.uisrael.hikvision.backend.dominio.enums.EstadoRegistro;
import com.uisrael.hikvision.backend.dominio.enums.TipoDispositivo;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dispositivos",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_dispositivo_codigo", columnNames = {"codigo"}),
                @UniqueConstraint(name = "uk_dispositivo_mac", columnNames = {"mac_address"})
        },
        indexes = {
                @Index(name = "idx_dispositivo_piso", columnList = "piso_id"),
                @Index(name = "idx_dispositivo_ip", columnList = "ip")
        })
public class DispositivoJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dispositivo_id")
    private Long id;

    @Column(name = "codigo", length = 80, nullable = false)
    private String codigo;

    @Column(name = "ip", length = 45, nullable = false)
    private String ip;

    @Column(name = "puerto", nullable = false)
    private Integer puerto;

    @Column(name = "modelo", length = 80)
    private String modelo;

    @Column(name = "ubicacion", length = 120)
    private String ubicacion;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", length = 30, nullable = false)
    private EstadoRegistro estado;

    // Nuevos campos para conexion con Hikvision
    @Column(name = "usuario_dispositivo", length = 100)
    private String usuarioDispositivo;

    @Column(name = "contrasena_dispositivo", length = 255)
    private String contrasenaDispositivo;

    @Column(name = "mac_address", length = 17)
    private String macAddress;

    @Column(name = "numero_serie", length = 100)
    private String numeroSerie;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_dispositivo", length = 30)
    private TipoDispositivo tipoDispositivo;

    @Column(name = "firmware_version", length = 50)
    private String firmwareVersion;

    @Column(name = "habilitado")
    private Boolean habilitado;

    // Relacion con Piso
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "piso_id",
            foreignKey = @ForeignKey(name = "fk_dispositivo_piso"))
    private PisoJpaEntity piso;
}
