package com.salesianostriana.dam.ejemplotestingspringboot;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistroMeteorologicoRepo
        extends JpaRepository<RegistroMeteorologico, Long> {

    /**
     * Este tipo de consultas, derivadas del nombre del método, son comprobadas por
     * Spring Data al compilar, para verificar que son correctoas, y posteriormente
     * traducirlas a la consulta correspondiente.
     * Posiblemente, no merezca la pena testearlas; esto sucederá si son consultas
     * simples. Para alguna consulta más compleja, que implique JOINs o varias condiciones
     * es posible que sí tengamos que implementar algún test.
     */

    List<RegistroMeteorologicoRepo> findByEstacion(String estacion);
    List<RegistroMeteorologico> findByProvincia(String provincia);





}
