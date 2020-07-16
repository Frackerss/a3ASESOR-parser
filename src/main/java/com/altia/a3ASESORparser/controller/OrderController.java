package com.altia.a3ASESORparser.controller;

import com.altia.a3ASESORparser.model.a3ASESOR.Registro;
import com.altia.a3ASESORparser.model.pizza.Order;
import com.altia.a3ASESORparser.service.OrderParser;
import com.altia.a3ASESORparser.service.Parser;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/parser")
@RequiredArgsConstructor
public class OrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParserController.class);

    private final OrderParser service;

    @PostMapping(value = {"", "/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> parse(List<Order> orders) {

        LOGGER.info(">>Init parser {}", orders);
        service.parse(orders);
        LOGGER.info(">>End parser {}", orders);
        return ResponseEntity.ok("Peticion parseada correctamente.");
    }

}
