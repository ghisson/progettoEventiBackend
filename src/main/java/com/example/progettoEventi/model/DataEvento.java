package com.example.progettoEventi.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class DataEvento {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_data_evento")
	private long idDataEvento;
	@Column(name="data_inizio")
	private Date dataInizio;
	@Column(name="data_fine")
	private Date dataFine;
	//fk_id_evento
	
	
	public DataEvento() {}
	public DataEvento(long idDataEvento, Date dataInizio, Date dataFine) {
		this.idDataEvento=idDataEvento;
		this.dataInizio=dataInizio;
		this.dataFine=dataFine;
	}
	
	public long getIdDataEvento() {
		return idDataEvento;
	}
	public void setIdDataEvento(long idDataEvento) {
		this.idDataEvento = idDataEvento;
	}
	public Date getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}
	public Date getDataFine() {
		return dataFine;
	}
	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}
	@Override
	public String toString() {
		return "DataEvento [idDataEvento=" + idDataEvento + ", dataInizio=" + dataInizio + ", dataFine=" + dataFine
				+ "]";
	}
	
	
}
