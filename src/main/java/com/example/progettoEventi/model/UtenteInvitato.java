package com.example.progettoEventi.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UtenteInvitato {
	
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
	
	
	
	

}
