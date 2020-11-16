package com.salesianostriana.dam.ejemplotestingspringboot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class RegistroMeteorologico {

    @Id @GeneratedValue
    private long id;

    private LocalDate fecha;
    private String estacion, provincia;
    private double temperatura_maxima, temperatura_minima;

    public double getTemperaturaPromedio() {
        return (temperatura_maxima + temperatura_minima) / 2.0;
    }

}
