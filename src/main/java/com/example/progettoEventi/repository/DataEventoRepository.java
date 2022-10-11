package com.example.progettoEventi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.progettoEventi.model.DataEvento;


public interface DataEventoRepository  extends JpaRepository<DataEvento, Long> {

}
