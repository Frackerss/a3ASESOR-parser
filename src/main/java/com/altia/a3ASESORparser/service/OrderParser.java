package com.altia.a3ASESORparser.service;

import com.altia.a3ASESORparser.model.a3ASESOR.Registro;
import com.altia.a3ASESORparser.model.pizza.Order;

import java.util.List;

public interface OrderParser {

    void parse(List<Order> orders);

}