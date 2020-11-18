package com.salesianostriana.dam.ejemplotestingspringboot;

import com.salesianostriana.dam.ejemplotestingspringboot.repositorio.RegistroMeteorologicoRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class EjemploTestingSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjemploTestingSpringbootApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(RegistroMeteorologicoRepo repositorio) {
		return args -> {
			repositorio
					.findByEstacionContainsIgnoreCaseAndProvinciaAndFechaBetween("Marbella",
							"Málaga",
							LocalDate.of(2019, 7, 1),
							LocalDate.of(2019, 11,1)
					).forEach(System.out::println);
		};
	}



}
