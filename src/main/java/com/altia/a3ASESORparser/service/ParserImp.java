package com.altia.a3ASESORparser.service;

import com.altia.a3ASESORparser.model.AppException;
import com.altia.a3ASESORparser.model.Registro;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
public class ParserImp implements Parser {

    private final static String NOMBRE_FICHERO = "SUENLAC5.TXT";

    private void crearFichero() throws AppException {
        File file = new File(NOMBRE_FICHERO);
        try {
            file.createNewFile();
        } catch (IOException ex) {
            throw new AppException("Error creando el fichero: " + NOMBRE_FICHERO, ex);
        }
    }

    private void reset() {
        File file = new File(NOMBRE_FICHERO);
        file.delete();
    }

    public static void salvar(List<Registro> registros) throws AppException {
        try {
            PrintWriter pw = new PrintWriter(new
                    BufferedWriter(new FileWriter(NOMBRE_FICHERO)), true);
            for (Registro r : registros) {
                pw.println(r.serialize());
            }
            pw.close();
        } catch (IOException e) {
            throw new AppException("Error salvando datos. ", e);
        }
    }

    @Override
    public void parse(List<Registro> registros) {
        reset();
        crearFichero();
        salvar(registros);
    }
}
