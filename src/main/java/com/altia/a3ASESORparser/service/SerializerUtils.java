package com.altia.a3ASESORparser.service;

import java.util.Collections;

public class SerializerUtils {

    private SerializerUtils() {
    }

    public static String serialize(final boolean input) {
        return input ? "S" : " ";
    }

    public static String serialize(final String inputString, final int length) {
        return String.format("%" + length + "." + length + "s", inputString);
    }

    public static String serialize(final int inputInt, final int length) {
        return String.format("%0" + length + "d", inputInt);
    }

    public static String serialize(
            final double inputDouble,
            final int length,
            final int decimals) {
        return String.format("%+" + length + "." + decimals + "f", inputDouble);
    }

    public static String reserva() {
        return String.join("", Collections.nCopies(137, " "));
    }
}
