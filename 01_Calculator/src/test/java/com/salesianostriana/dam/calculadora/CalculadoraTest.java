package com.salesianostriana.dam.calculadora;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class CalculadoraTest {

    static Calculadora calculadora;

    @BeforeAll
    static void setUp() {
        calculadora = new Calculadora();
    }

    @Test
    @DisplayName("1 + 1 = 2")
    void sumarDosNumeros() {
        assertEquals(2, calculadora.sumar(1,1), "1 + 1 debe ser igual a 2");
    }


    @ParameterizedTest
    @CsvSource({
            "0,     1,      1",
            "1,     2,      3",
            "49,    51,     100",
            "1,     100,    101"
    })
    void sumar(int primero, int segundo, int resultadoEsperado) {
        assertEquals(resultadoEsperado, calculadora.sumar(primero, segundo),
                () -> primero + " + " + segundo + " debe ser igual a " + resultadoEsperado);
    }

    @Test
    @DisplayName("3 / 2 = 1.5")
    void dividirEnteros() {
        int a = 3;
        int b = 2;
        // assertEquals(1.5, calculadora.dividir(a,b));
        // Podemos hacer uso de Hamcrest para hacer más legible el aserto
        assertThat(calculadora.dividir(a,b), is(equalTo(1.5)));
    }


    @ParameterizedTest(name = "{displayName} - {arguments}")
    @CsvSource({
            "1,     1,      1",
            "3,     2,      1.5",
            "5,     2,      2.5",
            "1,     3,      0.33"
    })
    void dividir(int a, int b, double result) {
        assertThat(calculadora.dividir(a,b), is(closeTo(result, 0.01)));
    }

    // closeTo nos permite verificar si dos valores numéricos son iguales con
    // un cierto margen de error


    @Test
    @DisplayName("División entre cero")
    void dividirEntreCero() {
        assertEquals(Double.POSITIVE_INFINITY, calculadora.dividir(1,0));
    }





}