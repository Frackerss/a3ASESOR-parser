package com.altia.a3ASESORparser.service;

import com.altia.a3ASESORparser.model.a3ASESOR.Registro;

import java.util.List;


public interface Parser {

    void parse(List<Registro> registros);
}
