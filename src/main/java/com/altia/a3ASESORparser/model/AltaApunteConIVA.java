package com.altia.a3ASESORparser.model;

import lombok.Data;

import java.util.Collections;

@Data
public class AltaApunteConIVA extends Registro {

    private String cuenta;
    private String descripcionCuenta;
    private TipoFactura tipoFactura;
    private int numeroFactura;
    private LineaApunte lineaApunte;
    private String descripcionApunte;
    private double importe;
    //reserva
    private String nifCliente;
    private String nombreCliente;
    private int codigoPostal;
    //reserva
    private int fechaOperacion;
    private int fechaFactura;
    private int numeroFacturaAmpliado;
    //reserva
    private Moneda moneda;

    public AltaApunteConIVA() {
        super();
        tipoRegistro = 1;
    }

    @Override
    public String serializeExpecific() {
        return cuenta
                + descripcionCuenta
                //+ tipoImporte
                //+ referenciaDocumento
                + lineaApunte
                + descripcionApunte
                + importe
                + String.join("", Collections.nCopies(137, " "))
                //+ asientoNomina
                //+ registroAnalitico
                + String.join("", Collections.nCopies(256, " "))
                + moneda;
    }
}
