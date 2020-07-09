package com.altia.a3ASESORparser.model;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public abstract class Registro {

    private final static int TIPO_FORMATO = 5;
    @Min(1) @Max(99999)
    private int codigoEmpresa;
    @Min(19000000) @Max(2999999)
    private int fechaApunte;
    protected int tipoRegistro;

    private final static String INDICADOR_GENERANDO = "N";

    public final String serialize() {
        return serialiceInit() + serializeExpecific() + serialiceEnd();
    }

    public abstract String serializeExpecific();

    public final String serialiceInit() {
        return ""
                + TIPO_FORMATO
                + String.format("%020d", codigoEmpresa)
                + fechaApunte
                + tipoRegistro;
    }

    public final String serialiceEnd() {
        return INDICADOR_GENERANDO;
    }

}
