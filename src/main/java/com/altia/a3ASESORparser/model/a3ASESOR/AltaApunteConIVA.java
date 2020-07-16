package com.altia.a3ASESORparser.model.a3ASESOR;

import com.altia.a3ASESORparser.service.SerializerUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collections;

@EqualsAndHashCode(callSuper = true)
@Data
public class AltaApunteConIVA extends Registro {

    private int cuenta;
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
        return SerializerUtils.serialize(SerializerUtils.serialize(cuenta, 6), 12)
                + SerializerUtils.serialize(descripcionCuenta, 30)
                + tipoFactura
                + SerializerUtils.serialize(numeroFactura, 10)
                + lineaApunte
                + SerializerUtils.serialize(descripcionApunte, 30)
                + SerializerUtils.serialize(importe, 10, 2)
                + String.join("", Collections.nCopies(137, " "))
                + SerializerUtils.serialize(nifCliente, 14)
                + SerializerUtils.serialize(nombreCliente, 40)
                + SerializerUtils.serialize(codigoPostal, 5)
                + String.join("", Collections.nCopies(256, " "))
                + SerializerUtils.serialize(fechaOperacion, 8)
                + SerializerUtils.serialize(fechaFactura, 8)
                + SerializerUtils.serialize(numeroFacturaAmpliado, 60)
                + moneda;
    }
}
