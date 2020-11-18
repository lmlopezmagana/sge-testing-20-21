package com.salesianostriana.dam.ejemplotestingspringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class RegistroMeteorologioRepositoryJpaTest {


    @Autowired
    RegistroMeteorologicoRepo repositorio;


    @Test
    void test_complexQueryRun() {

    }


    
}
