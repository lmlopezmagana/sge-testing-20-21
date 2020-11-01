package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ejercicio01Test {

    /*
        a) Comprueba que Collections::sort ordena correctamente un objeto de tipo List<Integer>

        Le pasamos una colección desordenada, y la devuelve ordenada
        Añadimos algún número repetido para comprobar que los pone seguidos.

        ¿Otras posibles pruebas?
            - Lista vacía
            - Lista ya ordenada
            - .....

     */

    @Test
    @DisplayName("Ordena lista desordenada")
    void listaEnterosOrdenada() {

        // Esta lista se crea con Arrays.asList para que no nos de UnsupportedException al ordenar los elementos
        List<Integer> lista = Arrays.asList(9, 5, 8, 7, 3, 1, 6, 5, 4, 9, 10);
        // Al crear la lista con List.of, es inmutable, y no se puede modificar
        List<Integer> listaEsperada = List.of(1,3,4,5,5,6,7,8,9,9,10);

        // El método Collections.sort modifica la lista que se le pasa como argumento
        // y devuelve void.
        Collections.sort(lista);

        // Si ambas listas son iguales, la prueba es existosa
        assertEquals(listaEsperada, lista);

    }


    /*
        b) Compruebe que Collections:addAll añade todos los números indicados a un objeto de tipo List<Integer>

         i. Partimos de una lista con algún elemento.
         ii. Le añadimos con addAll otros cuantos elementos.
         iii. Comprobamos que están todos.

     */

    @Test
    @DisplayName("Añadir varios elementos a una lista dada")
    void addListaAOtraLista() {

        List<Integer> lista = new ArrayList<>(List.of(1,2,3));
        List<Integer> resultadoEsperado = List.of(1,2,3,4,5,6);

        Collections.addAll(lista, 4, 5, 6);

        // Si ambas listas son iguales, la prueba es existosa
        assertEquals(resultadoEsperado, lista);


    }


    /*
        c) Compruebe que el método Collections::max devuelve el mayor valor de una lista de enteros.

     */

    @Test
    @DisplayName("Añadir varios elementos a una lista dada")
    void mayorDeUnaListaConElementos() {

        List<Integer> lista = List.of(123,456,789);
        int resultadoEsperado = 789;
        assertEquals(resultadoEsperado, Collections.max(lista));

    }
}
