package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Ejercicio01TestSolucion2 {


    /**
     * e = lista vacía, r = lista vacía
     * e = { 3,2,1 }, r = { 1,2,3}
     * e = { 1,1,2,3,2}, r = {1,1,2,2,3}
     * e = {null, 1, 3, 2}, r = { null, 1, 2, 3}
     * e = lista no modificable, r = throws UnsupportedOperationException
     */

    @ParameterizedTest
    @MethodSource("datosTestOrdenarLista")
    void testOrdenarLista(List<Integer> entrada, List<Integer> resultadoEsperado) {
        Collections.sort(entrada);
        assertEquals(resultadoEsperado, entrada);
    }

    static Stream<Arguments> datosTestOrdenarLista() {
        return Stream.of(
                arguments(new ArrayList<Integer>(), new ArrayList<Integer>()),
                arguments(Arrays.asList(3,2,1), Arrays.asList(1,2,3)),
                arguments(Arrays.asList(1,1,2,3,2), Arrays.asList(1,1,2,2,3)),
                arguments(Arrays.asList(null, 1, 3, 2), Arrays.asList(null, 1, 2, 3))
        );
    }

    @Test
    void listaConNuloLanzaNPE() {
        assertThrows(NullPointerException.class, () -> {
            Collections.sort(Arrays.asList(null, 1, 3, 2));
        });
    }

    @Test
    void listaNoModificableLanzaUOE() {
        assertThrows(UnsupportedOperationException.class, () -> {
            Collections.sort(List.of(1,2,3));
        });
    }

    @ParameterizedTest
    @MethodSource("datosTestOrdenarListaConExcepciones")
    void listaOrdenadaLanzaExcepcion(List<Integer> datos, Class<Exception> exceptionClass) {
        assertThrows(exceptionClass, () -> {
            Collections.sort(datos);
        });
    }

    static Stream<Arguments> datosTestOrdenarListaConExcepciones() {
        return Stream.of(
                arguments(Arrays.asList(null, 1, 3, 2), NullPointerException.class),
                arguments(List.of(1,2,3), UnsupportedOperationException.class)
        );
    }



}
