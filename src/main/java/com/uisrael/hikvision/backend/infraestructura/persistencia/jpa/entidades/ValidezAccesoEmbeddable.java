package com.uisrael.hikvision.backend.infraestructura.persistencia.jpa.entidades;

import com.uisrael.hikvision.backend.dominio.enums.TipoTiempo;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ValidezAccesoEmbeddable {

    @Column(name = "validez_habilitado")
    private Boolean habilitado;

    @Column(name = "validez_fecha_inicio")
    private LocalDateTime fechaInicio;

    @Column(name = "validez_fecha_fin")
    private LocalDateTime fechaFin;

    @Enumerated(EnumType.STRING)
    @Column(name = "validez_tipo_tiempo", length = 20)
    private TipoTiempo tipoTiempo;
}
