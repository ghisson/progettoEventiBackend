package com.example.progettoEventi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.progettoEventi.model.Utente;

public interface UserRepository extends JpaRepository<Utente, Long> {
	
	Utente findByEmail(String email);
	Utente findByCodiceFiscale(String codice_fiscale);
}
