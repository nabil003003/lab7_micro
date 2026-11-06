package com.example.lab6_micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.lab6_micro.repository.CompteRepository;
import com.example.lab6_micro.model.Compte;
import com.example.lab6_micro.model.TypeCompte;

import java.util.Date;

@SpringBootApplication
public class Lab6MicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lab6MicroApplication.class, args);
	}

	@Bean
	CommandLineRunner initializeAccounts(CompteRepository compteRepository) {
		return args -> {
			compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.EPARGNE));
			compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.COURANT));
			compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.EPARGNE));
			compteRepository.findAll().forEach(System.out::println);
		};
	}

}
