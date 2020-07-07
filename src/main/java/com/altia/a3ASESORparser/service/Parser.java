package com.altia.a3ASESORparser.service;

import com.altia.a3ASESORparser.model.Registro;
import org.springframework.stereotype.Service;

import java.util.List;


public interface Parser {

    void parse(List<Registro> registros);
}
