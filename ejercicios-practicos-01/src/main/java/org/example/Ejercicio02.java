package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Ejercicio02 {

    // Versión con genéricos
    public static <T> Collection<T> interseccion(Collection<T> a, Collection<T> b) {
        // Afortunadamente, Java nos provee de lo necesario y no tenemos
        // que recorrer ambas listas, comparar, etc...

        // Creamos una colección vacía
        Collection<T> result = new ArrayList<>();
        // Añadimos todos los elementos de a
        result.addAll(a);
        // Dejamos en result todos los elementos que a la vez están en b
        // Por tanto, ya tenemos hecha la intersección.
        result.retainAll(b);

        return result;

    }

    // Versión para List<Integer>, por si los genéricos te hacen
    // explotar la cabeza :S
    public static List<Integer> interseccionListaEnteros(List<Integer> a, List<Integer> b) {
        List<Integer> result = new ArrayList<>();
        result.addAll(a);
        result.retainAll(b);
        return result;
    }


}
