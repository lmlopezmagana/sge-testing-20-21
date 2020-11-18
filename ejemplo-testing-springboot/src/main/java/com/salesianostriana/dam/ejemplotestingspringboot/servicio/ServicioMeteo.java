package com.salesianostriana.dam.ejemplotestingspringboot.servicio;

import com.salesianostriana.dam.ejemplotestingspringboot.repositorio.RegistroMeteorologicoRepo;
import com.salesianostriana.dam.ejemplotestingspringboot.modelo.RegistroMeteorologico;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServicioMeteo {

    private final RegistroMeteorologicoRepo repositorio;


    /**
     * Método que obtiene la temperatura media entre dos fechas para todas las poblaciones
     * @param fechaInicio
     * @param fechaFin
     * @return
     */
    public double temperaturaMediaEntreFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        return mediaGenerica(fechaInicio, fechaFin, null);
    }

    /**
     * Método que obtiene la temperatura media entre dos fechas para una provincia concreta
     * @param provincia
     * @param fechaInicio
     * @param fechaFin
     * @return
     */
    public double temperaturaMediaProvinciaEntreFechas(String provincia, LocalDate fechaInicio, LocalDate fechaFin) {
        return mediaGenerica(fechaInicio, fechaFin, provincia);
    }

    private double mediaGenerica(LocalDate fechaInicio, LocalDate fechaFin, String provincia) {

        Predicate<RegistroMeteorologico> predicado = r -> r.getFecha().isAfter(fechaInicio.minusDays(1)) && r.getFecha().isBefore(fechaFin.plusDays(1));
        if (provincia != null) {
            predicado = predicado.and(r -> r.getProvincia().equalsIgnoreCase(provincia));
        }

        return repositorio.findAll().stream()
                .filter(predicado)
                .mapToDouble(RegistroMeteorologico::getTemperaturaPromedio)
                .average()
                .orElse(0);
    }


    public Map<String, Double> temperaturaMediaDelMesPorProvincia(String mes) {
        return repositorio.findAll().stream()
                .filter(r -> fechaAMes(r.getFecha()).equalsIgnoreCase(mes))
                .collect(Collectors.groupingBy(RegistroMeteorologico::getProvincia,
                        Collectors.averagingDouble(RegistroMeteorologico::getTemperaturaPromedio)));
    }

    private String fechaAMes(LocalDate date) {
        return date.getMonth().getDisplayName(TextStyle.FULL, new Locale("es")).toUpperCase();
    }








}
