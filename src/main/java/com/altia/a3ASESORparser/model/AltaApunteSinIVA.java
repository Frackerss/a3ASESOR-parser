package com.altia.a3ASESORparser.model;

import com.altia.a3ASESORparser.service.SerializerUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Size;
import java.util.Collections;

@EqualsAndHashCode(callSuper = true)
@Data
public class AltaApunteSinIVA extends Registro {

    private String cuenta;
    private String descripcionCuenta;
    private TipoImporte tipoImporte;
    private String referenciaDocumento;
    private LineaApunte lineaApunte;
    @Size(max = 30)
    private String descripcionApunte;
    private double importe;
    //reserva
    private boolean asientoNomina;
    private boolean registroAnalitico;
    //reserva
    private Moneda moneda;

    public AltaApunteSinIVA() {
        super();
        tipoRegistro = 0;
    }

    @Override
    public String serializeExpecific() {
        return SerializerUtils.serialize(SerializerUtils.serialize(cuenta, 6), 12)
                + SerializerUtils.serialize(descripcionCuenta, 30)
                + tipoImporte
                + SerializerUtils.serialize(referenciaDocumento, 10)
                + lineaApunte
                + SerializerUtils.serialize(descripcionApunte, 10)
                + SerializerUtils.serialize(importe, 10, 2)
                + SerializerUtils.reserva()
                + SerializerUtils.serialize(asientoNomina)
                + SerializerUtils.serialize(registroAnalitico)
                + SerializerUtils.reserva()
                + moneda;
    }
}
