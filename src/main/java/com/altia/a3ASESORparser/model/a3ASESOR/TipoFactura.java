package com.altia.a3ASESORparser.model.a3ASESOR;

public enum TipoFactura {
    VENTAS(1),
    COMPRAS(2),
    BIENES_INVERSION(3);

    private int value;

    TipoFactura(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
