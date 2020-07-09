package com.altia.a3ASESORparser.model;

import lombok.Data;

import javax.validation.constraints.Size;
import java.util.Collections;

@Data
public class AltaApunteSinIVA extends Registro {

    @Size(min=6, max=12)
    private String cuenta;
    @Size(max=30)
    private String descripcionCuenta;
    private TipoImporte tipoImporte;
    @Size(max=10)
    private String referenciaDocumento;
    private LineaApunte lineaApunte;
    @Size(max=30)
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
        return cuenta
                + descripcionCuenta
                + tipoImporte
                + referenciaDocumento
                + lineaApunte
                + descripcionApunte
                + String.format("%+10.2f", importe)
                + String.join("", Collections.nCopies(137, " "))
                + asientoNomina
                + registroAnalitico
                + String.join("", Collections.nCopies(256, " "))
                + moneda;
    }
}
