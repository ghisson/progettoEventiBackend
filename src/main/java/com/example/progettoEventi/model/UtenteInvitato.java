package com.example.progettoEventi.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class UtenteInvitato implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_utente_invitato")
	private long idUtenteInvitato;
	
	@Column(name = "codice_fiscale")
	private String codiceFiscale;
	
	//fk_prenotazione_effettuata
	
	public UtenteInvitato() {}

	public UtenteInvitato(long idUtenteInvitato, String codiceFiscale) {
		super();
		this.idUtenteInvitato = idUtenteInvitato;
		this.codiceFiscale = codiceFiscale;
	}
	
	public UtenteInvitato(String codFiscale,PrenotazioneEffettuata pr) {
		this.codiceFiscale=codFiscale;
		setPrenotazioneEffettuata(pr);
	}

	public long getIdUtenteInvitato() {
		return idUtenteInvitato;
	}

	public void setIdUtenteInvitato(long idUtenteInvitato) {
		this.idUtenteInvitato = idUtenteInvitato;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	@Override
	public String toString() {
		return "UtenteInvitato [idUtenteInvitato=" + idUtenteInvitato + ", codiceFiscale=" + codiceFiscale + "]";
	}
	
	
	@ManyToOne
    @JoinColumn(name = "fk_prenotazione_effettuata", referencedColumnName = "id_prenotazione_effettuata")
	@JsonIgnoreProperties("utentiInvitati")
	
	private PrenotazioneEffettuata prenotazioneEffettuata;
	
	public PrenotazioneEffettuata getPrenotazioneEffettuata() {
		return prenotazioneEffettuata;
	}
	public void setPrenotazioneEffettuata(PrenotazioneEffettuata prenotazioneEffettuata) {
		this.prenotazioneEffettuata=prenotazioneEffettuata;
	}
	
	
	

}
