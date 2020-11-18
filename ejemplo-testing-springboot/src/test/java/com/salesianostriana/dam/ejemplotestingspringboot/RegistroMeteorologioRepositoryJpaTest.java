package com.salesianostriana.dam.ejemplotestingspringboot;

import com.salesianostriana.dam.ejemplotestingspringboot.repositorio.RegistroMeteorologicoRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class RegistroMeteorologioRepositoryJpaTest {


    @Autowired
    RegistroMeteorologicoRepo repositorio;


    @Test
    void test_complexQueryRun() {
        assertEquals(true, true);
    }



}
