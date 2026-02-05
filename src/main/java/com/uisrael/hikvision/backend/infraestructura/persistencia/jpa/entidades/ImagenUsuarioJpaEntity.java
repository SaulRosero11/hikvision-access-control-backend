package com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.entidades;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "imagenes_usuario")
public class ImagenUsuarioJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "imagen_usuario_id")
    private Long id;

    @Column(name = "imagen_base64", columnDefinition = "TEXT", nullable = false)
    private String imagenBase64;

    @Column(name = "tipo_imagen", length = 20)
    private String tipoImagen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_imagen_usuario"))
    private UsuarioJpaEntity usuario;
}
