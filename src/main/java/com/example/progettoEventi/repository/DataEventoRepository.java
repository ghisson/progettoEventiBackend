package com.example.progettoEventi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.progettoEventi.model.DataEvento;
import com.example.progettoEventi.model.Evento;


public interface DataEventoRepository  extends JpaRepository<DataEvento, Long> {
	List<DataEvento> findByEvento(Evento evento);
}
