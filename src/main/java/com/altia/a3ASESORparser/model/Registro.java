package com.altia.a3ASESORparser.model;

import com.altia.a3ASESORparser.service.SerializerUtils;
import lombok.Data;

@Data
public abstract class Registro {

    private final static int TIPO_FORMATO = 5;
    private int codigoEmpresa;
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
                + SerializerUtils.serialize(SerializerUtils.serialize(codigoEmpresa, 5), 20)
                + SerializerUtils.serialize(fechaApunte, 8)
                + tipoRegistro;
    }

    public final String serialiceEnd() {
        return INDICADOR_GENERANDO;
    }

}
