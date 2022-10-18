package com.example.progettoEventi.model;

public class SupportoRecensione {

	String recensione;
	int votoRecensione;
	
	public SupportoRecensione() {}
	
	

	public SupportoRecensione(String recensione, int votoRecensione) {
		super();
		this.recensione = recensione;
		this.votoRecensione = votoRecensione;
	}



	public String getRecensione() {
		return recensione;
	}

	public void setRecensione(String recensione) {
		this.recensione = recensione;
	}

	public int getVotoRecensione() {
		return votoRecensione;
	}

	public void setVotoRecensione(int votoRecensione) {
		this.votoRecensione = votoRecensione;
	}
	
	
	
}
