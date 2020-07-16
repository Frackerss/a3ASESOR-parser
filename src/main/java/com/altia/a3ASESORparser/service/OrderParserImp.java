package com.altia.a3ASESORparser.service;

import com.altia.a3ASESORparser.model.a3ASESOR.AppException;
import com.altia.a3ASESORparser.model.a3ASESOR.Registro;
import com.altia.a3ASESORparser.model.pizza.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderParserImp implements OrderParser {

    private final Parser parser;

    @Override
    public void parse(List<Order> orders) {

        //DO the magic here

        final List<Registro> resgistros = new ArrayList<>();
        parser.parse(resgistros);
    }

}
