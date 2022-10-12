package com.example.progettoEventi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.progettoEventi.model.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Long> {
	
	Optional<Utente> findByEmail(String email);
	Optional<Utente> findByCodiceFiscale(String codice_fiscale);
}
