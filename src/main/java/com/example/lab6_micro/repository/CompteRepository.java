package com.example.lab6_micro.repository;

import com.example.lab6_micro.model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, Long> {
}
