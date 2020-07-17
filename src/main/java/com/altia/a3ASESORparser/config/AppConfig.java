package com.altia.a3ASESORparser.config;

import com.altia.a3ASESORparser.model.a3ASESOR.Moneda;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Getter
    @Value("${cuentaEmpresa}")
    private int cuentaEmpresa;
    @Getter
    private Moneda moneda = Moneda.E;

}
