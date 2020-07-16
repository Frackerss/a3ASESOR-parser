package com.altia.a3ASESORparser.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collections;

@EqualsAndHashCode(callSuper = true)
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
                + tipoFactura
                + numeroFactura
                + lineaApunte
                + descripcionApunte
                + importe
                + String.join("", Collections.nCopies(137, " "))
                + nifCliente
                + nombreCliente
                + codigoPostal
                + String.join("", Collections.nCopies(256, " "))
                + fechaOperacion
                + fechaFactura
                + numeroFacturaAmpliado
                + moneda;
    }
}
