package com.example.progettoEventi.model;

import java.time.LocalDate;

public class SupportoPrenotazione {
	
	private String carta;
	private String intestatario;
	private String cvv;
	private LocalDate dataScadenza;
	
	private long idUtente;
	private long idSettoreDataEvento;
	
	private String[] utentiInvitati;
	
	
	public SupportoPrenotazione() {}


	public SupportoPrenotazione(String carta, String intestatario, String cvv, LocalDate dataScadenza, long idUtente,
			long idSettoreDataEvento, String[] utentiInvitati) {
		super();
		this.carta = carta;
		this.intestatario = intestatario;
		this.cvv = cvv;
		this.dataScadenza = dataScadenza;
		this.idUtente = idUtente;
		this.idSettoreDataEvento = idSettoreDataEvento;
		this.utentiInvitati = utentiInvitati;
	}


	public String getCarta() {
		return carta;
	}


	public void setCarta(String carta) {
		this.carta = carta;
	}


	public String getIntestatario() {
		return intestatario;
	}


	public void setIntestatario(String intestatario) {
		this.intestatario = intestatario;
	}


	public String getCvv() {
		return cvv;
	}


	public void setCvv(String cvv) {
		this.cvv = cvv;
	}


	public LocalDate getDataScadenza() {
		return dataScadenza;
	}


	public void setDataScadenza(LocalDate dataScadenza) {
		this.dataScadenza = dataScadenza;
	}


	public long getIdUtente() {
		return idUtente;
	}


	public void setIdUtente(long idUtente) {
		this.idUtente = idUtente;
	}


	public long getIdSettoreDataEvento() {
		return idSettoreDataEvento;
	}


	public void setIdSettoreDataEvento(long idSettoreDataEvento) {
		this.idSettoreDataEvento = idSettoreDataEvento;
	}


	public String[] getUtentiInvitati() {
		return utentiInvitati;
	}


	public void setUtentiInvitati(String[] utentiInvitati) {
		this.utentiInvitati = utentiInvitati;
	}
	
	

}
