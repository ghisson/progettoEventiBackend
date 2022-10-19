package com.example.progettoEventi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.progettoEventi.model.PrenotazioneEffettuata;
import com.example.progettoEventi.model.SettoreDataEvento;

public interface PrenotazioneEffettuataRepository extends JpaRepository<PrenotazioneEffettuata, Long> {
	List<PrenotazioneEffettuata> findBySettoreDataEvento(SettoreDataEvento settoreDataEvento);
}
