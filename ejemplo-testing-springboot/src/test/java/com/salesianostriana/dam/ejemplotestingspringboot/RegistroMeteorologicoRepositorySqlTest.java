package com.salesianostriana.dam.ejemplotestingspringboot;


import com.salesianostriana.dam.ejemplotestingspringboot.configuracion.TestDBConfig;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.*;
import com.salesianostriana.dam.ejemplotestingspringboot.repositorio.RegistroMeteorologicoRepo;
import com.salesianostriana.dam.ejemplotestingspringboot.modelo.RegistroMeteorologico;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = { TestDBConfig.class, EjemploTestingSpringbootApplication.class}  )
@ActiveProfiles("test")
public class RegistroMeteorologicoRepositorySqlTest {

    @Autowired
    RegistroMeteorologicoRepo repositorio;


    @Test
    @Sql(statements = "INSERT INTO registro_meteorologico (id, fecha, estacion, provincia, temperatura_maxima, temperatura_minima) VALUES (1001, '2019-09-02','Sevilla','Sevilla',35.4,21.0)")
    public void testBusquedaPorProvincia() {

        List<RegistroMeteorologico> resultado = repositorio.findByProvincia("Sevilla");

        assertEquals(1, resultado.size());


    }










}
