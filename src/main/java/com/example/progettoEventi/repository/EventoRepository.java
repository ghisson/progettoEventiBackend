package com.example.progettoEventi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.progettoEventi.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {
	
}
