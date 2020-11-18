package com.salesianostriana.dam.ejemplotestingspringboot;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

import static org.springframework.core.Ordered.LOWEST_PRECEDENCE;


// Pasar a un command line runner
@Component
@RequiredArgsConstructor
public class DemoComponent {

    private final RegistroMeteorologicoRepo repositorio;
    private final ServicioMeteo servicio;

    Logger logger = LoggerFactory.getLogger(DemoComponent.class);

    @PostConstruct
    public void run() {
        logger.info("Ejecutando consulta compleja");
        // Consulta "compleja"
        repositorio
                .findByEstacionContainsIgnoreCaseAndProvinciaAndFechaBetween("Marbella",
                        "Málaga",
                        LocalDate.of(2019, 7, 1),
                        LocalDate.of(2019, 11,1)
                ).forEach(registroMeteorologico -> logger.info(registroMeteorologico.toString()));



    }


}
