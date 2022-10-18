package com.example.progettoEventi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.progettoEventi.model.DataEvento;
import com.example.progettoEventi.model.SettoreDataEvento;

public interface SettoreDataEventoRepository extends JpaRepository<SettoreDataEvento, Long> {
	
	List<SettoreDataEvento> findByDataEvento(DataEvento dataEvento);

}
