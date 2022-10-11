package com.example.progettoEventi.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.progettoEventi.model.Settore;


public interface SettoreRepository extends JpaRepository<Settore, Long> {
	
}
