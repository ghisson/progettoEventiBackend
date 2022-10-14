package com.example.progettoEventi.model;

import java.time.LocalDate;

public class Filtro {
	
	private String categoria;
	private String autore;
	private LocalDate dataInizio;
	private LocalDate dataFine;
	
	public Filtro() {}

	public Filtro(String categoria, String autore, LocalDate dataInzio, LocalDate dataFine) {
		super();
		this.categoria = categoria;
		this.autore = autore;
		this.dataInizio = dataInzio;
		this.dataFine = dataFine;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public LocalDate getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}

	public LocalDate getDataFine() {
		return dataFine;
	}

	public void setDataFine(LocalDate dataFine) {
		this.dataFine = dataFine;
	}
	
	

}
