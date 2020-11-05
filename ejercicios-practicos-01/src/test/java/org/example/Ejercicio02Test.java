package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class Ejercicio02Test {

    /*
         Escribe un conjunto de pruebas para verificar el comportamiento de un método
         que recibe como parámetro dos conjuntos ordenados (o dos listas o dos arrays
         ordenadas de menor a mayor) y devuelve un nuevo conjunto ordenado que contenga
         los elementos de ambos conjuntos.

        ¿Cómo podríamos saber el número de elementos comunes que
        había en ambos conjuntos de entrada?

        NOTA: A esto se le conoce como la intersección de dos colecciones

        ¿QUÉ PRUEBAS DEBERÍAMOS REALIZAR?

           CAJA BLANCA
           ===========

           a, b son colecciones; r es el resultado

           a = vacía, b = vacía, r = vacía
           a = { 1 }, b = { 1 }, r = { 1 }
           a = { 1 }, b = { 2 }, r = vacía
           a = { 1, 2 }, b = { 2, 3 }, r = { 2 }

           ¿Se cubre por completo el código que has escrito?
           Si no, CAJA NEGRA

     */

    // En lugar de hacer 4 métodos de test, podemos usar @ParametrizedTest + @MethodSource
    @ParameterizedTest
    @MethodSource("generadorListas")
    void interseccionDeDosListas(List<Integer> a, List<Integer> b, List<Integer> result) {

        assertEquals(result, Ejercicio02.interseccion(a,b));

    }

    static Stream<Arguments> generadorListas() {

        return Stream.of(
             arguments(Collections.emptyList(), Collections.emptyList(), Collections.emptyList()),
             arguments(List.of(1), List.of(1), List.of(1)),
             arguments(List.of(1), List.of(2), Collections.emptyList()),
                arguments(List.of(1,2), List.of(2,3), List.of(2)),
                arguments(List.of(1,2,3,4), List.of(2,3,4,5), List.of(2,3,4))
        );

    }


}
