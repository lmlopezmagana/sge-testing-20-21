package com.salesianostriana.dam.ejemplotestingspringboot;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistroMeteorologicoRepo
        extends JpaRepository<RegistroMeteorologico, Long> {

    List<RegistroMeteorologicoRepo> findByEstacion(String estacion);

    List<RegistroMeteorologico> findByProvincia(String provincia);



}
