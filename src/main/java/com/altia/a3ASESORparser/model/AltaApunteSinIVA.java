package com.altia.a3ASESORparser.model;

import lombok.Data;

import java.util.Collections;

@Data
public class AltaApunteSinIVA extends Registro {

    private String cuenta;
    private String descripcionCuenta;
    private TipoImporte tipoImporte;
    private String referenciaDocumento;
    private LineaApunte lineaApunte;
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
                + importe
                + String.join("", Collections.nCopies(137, " "))
                + asientoNomina
                + registroAnalitico
                + String.join("", Collections.nCopies(256, " "))
                + moneda;
    }
}
