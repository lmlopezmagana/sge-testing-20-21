package com.salesianostriana.dam.ejemplotestingspringboot;

import com.salesianostriana.dam.ejemplotestingspringboot.modelo.RegistroMeteorologico;
import com.salesianostriana.dam.ejemplotestingspringboot.repositorio.RegistroMeteorologicoRepo;
import com.salesianostriana.dam.ejemplotestingspringboot.servicio.ServicioMeteo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ServicioMeteoTest {


    @Mock
    RegistroMeteorologicoRepo repositorio;

    @InjectMocks
    ServicioMeteo servicio;


    /**
     * Lista con algunos datos de prueba
     */
    static List<RegistroMeteorologico> datos = List.of(
            new RegistroMeteorologico(1l, LocalDate.of(2020, 11, 1), "Úbeda", "Jaén", 20, 10),
            new RegistroMeteorologico(2l, LocalDate.of(2020, 11, 2), "Triana", "Sevilla", 25, 16),
            new RegistroMeteorologico(3l, LocalDate.of(2020, 11, 3), "Montilla", "Córdoba", 22.5, 11.3),
            new RegistroMeteorologico(4l, LocalDate.of(2020, 11, 4), "Baeza", "Jaén", 25, 10)

            );

    // El promedio de la temperatura media de los datos de prueba es este
    static double media = 17.475;



    @Test
    void temperaturaMediaDelMesPorProvinciaExito() {

        // Cuando invoquemos al método findAll del repositorio meteorologico devuelve la lista de datos de prueba
        Mockito.when(repositorio.findAll()).thenReturn(datos);

        // Resultado: temperatura media por provincia (de los datos de prueba)
        Map<String, Double> result = Map.of("Jaén", 16.25, "Sevilla", 20.5, "Córdoba", 16.9);

        // Aserto
        assertEquals(result, servicio.temperaturaMediaDelMesPorProvincia("Noviembre"));


        // Para los incrédulos
        System.out.println(repositorio.findAll());

    }

    @Test
    void temperaturaMediaProvinciaEntreFechas() {

        // Cuando invoquemos al método findAll del repositorio meteorologico devuelve la lista de datos de prueba
        Mockito.when(repositorio.findAll()).thenReturn(datos);

        // Resultado
        double result = media;

        // Aserto
        LocalDate inicio = LocalDate.of(2020,11,1),
                fin = LocalDate.of(2020,11,4);

        assertEquals(result, servicio.temperaturaMediaEntreFechas(inicio, fin));


    }
}