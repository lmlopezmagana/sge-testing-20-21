package com.salesianostriana.dam.ejemplotestingspringboot;

import org.apache.tomcat.jni.Local;
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
     *
     */


    static List<RegistroMeteorologico> datos = List.of(
            new RegistroMeteorologico(1l, LocalDate.of(2020, 11, 1), "Úbeda", "Jaén", 20, 10),
            new RegistroMeteorologico(2l, LocalDate.of(2020, 11, 2), "Triana", "Sevilla", 25, 16),
            new RegistroMeteorologico(3l, LocalDate.of(2020, 11, 3), "Montilla", "Córdoba", 22.5, 11.3),
            new RegistroMeteorologico(4l, LocalDate.of(2020, 11, 4), "Baeza", "Jaén", 25, 10)

            );

    static double media = 17.475;



    @Test
    void temperaturaMediaDelMesPorProvinciaExito() {

        Mockito.when(repositorio.findAll()).thenReturn(datos);

        Map<String, Double> result = Map.of("Jaén", 16.25, "Sevilla", 20.5, "Córdoba", 16.9);

        assertEquals(result, servicio.temperaturaMediaDelMesPorProvincia("Noviembre"));


        // Para los incrédulos
        System.out.println(repositorio.findAll());

    }

    @Test
    void temperaturaMediaProvinciaEntreFechas() {

        Mockito.when(repositorio.findAll()).thenReturn(datos);

        double result = media;

        assertEquals(result, servicio.temperaturaMediaEntreFechas(LocalDate.of(2020,11,1), LocalDate.of(2020,11,4)));


    }
}