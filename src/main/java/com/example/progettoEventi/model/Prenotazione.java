package com.example.progettoEventi.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Prenotazione {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_prenotazione")
	private long idPrenotazione;
	@Column(name = "data_prenotazione")
	private Date dataPrenotazione;
	//fk_utente
	//fk_settore_data_evento
	
	public Prenotazione() {}

	public Prenotazione(long idPrenotazione, Date dataPrenotazione) {
		super();
		this.idPrenotazione = idPrenotazione;
		this.dataPrenotazione = dataPrenotazione;
	}

	public long getIdPrenotazione() {
		return idPrenotazione;
	}

	public void setIdPrenotazione(long idPrenotazione) {
		this.idPrenotazione = idPrenotazione;
	}

	public Date getDataPrenotazione() {
		return dataPrenotazione;
	}

	public void setDataPrenotazione(Date dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}
	
	
}