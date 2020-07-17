package com.altia.a3ASESORparser.service;

import com.altia.a3ASESORparser.config.AppConfig;
import com.altia.a3ASESORparser.model.a3ASESOR.AltaApunteConIVA;
import com.altia.a3ASESORparser.model.a3ASESOR.LineaApunte;
import com.altia.a3ASESORparser.model.a3ASESOR.Registro;
import com.altia.a3ASESORparser.model.a3ASESOR.TipoFactura;
import com.altia.a3ASESORparser.model.pizza.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderParserImp implements OrderParser {

    private final Parser parser;

    private final AppConfig appConfig;

    @Override
    public void parse(List<Order> orders) {

        final List<Registro> resgistros = orders
                .stream().map(this::parse).collect(Collectors.toList());

        parser.parse(resgistros);
    }

    private Registro parse(Order order) {
        final AltaApunteConIVA altaApunteConIVA = new AltaApunteConIVA();
        altaApunteConIVA.setDescripcionApunte(order.toString());
        altaApunteConIVA.setNombreCliente(order.getCustomerName());
        altaApunteConIVA.setImporte(order.getPizzaPrice());
        //altaApunteConIVA.setFechaFactura(order.get);
        altaApunteConIVA.setCodigoEmpresa(appConfig.getCuentaEmpresa());
        altaApunteConIVA.setMoneda(appConfig.getMoneda());
        altaApunteConIVA.setLineaApunte(LineaApunte.I);
        altaApunteConIVA.setTipoFactura(TipoFactura.VENTAS);

        return altaApunteConIVA;
    }

}
