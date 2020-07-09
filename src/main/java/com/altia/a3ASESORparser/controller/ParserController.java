package com.altia.a3ASESORparser.controller;

import com.altia.a3ASESORparser.model.Registro;
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
public class ParserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParserController.class);

    private final Parser service;

    @PostMapping(value = {"", "/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> parse(List<Registro> registros) {

        LOGGER.info(">>Init parser {}", registros);
        service.parse(registros);
        LOGGER.info(">>End parser {}", registros);
        return ResponseEntity.ok("Peticion parseada correctamente.");
    }

}