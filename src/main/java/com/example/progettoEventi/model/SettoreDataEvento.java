package com.example.progettoEventi.model;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SettoreDataEvento {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_settore_data_evento")
	private long idSettoreDataEvento;
	
	@Column(name = "prezzo_biglietto")
	private double prezzoBiglietto;
	
	//fk_data_evento
	//fk_settore
	
	
	public SettoreDataEvento() {}

	public SettoreDataEvento(long idSettoreDataEvento, double prezzoBiglietto) {
		super();
		this.idSettoreDataEvento = idSettoreDataEvento;
		this.prezzoBiglietto = prezzoBiglietto;
	}

	public long getIdSettoreDataEvento() {
		return idSettoreDataEvento;
	}

	public void setIdSettoreDataEvento(long idSettoreDataEvento) {
		this.idSettoreDataEvento = idSettoreDataEvento;
	}

	public double getPrezzoBiglietto() {
		return prezzoBiglietto;
	}

	public void setPrezzoBiglietto(double prezzoBiglietto) {
		this.prezzoBiglietto = prezzoBiglietto;
	}

	@Override
	public String toString() {
		return "SettoreDataEvento [idSettoreDataEvento=" + idSettoreDataEvento + ", prezzoBiglietto=" + prezzoBiglietto
				+ "]";
	}
	
	
	
}
