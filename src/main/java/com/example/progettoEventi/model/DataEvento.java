package com.example.progettoEventi.model;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
public class DataEvento {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_data_evento")
	private long idDataEvento;
	@Column(name="data_inizio")
	private LocalDateTime dataInizio;
	@Column(name="data_fine")
	private LocalDateTime dataFine;
	//fk_id_evento
	
	public DataEvento() {}
	public DataEvento(long idDataEvento, LocalDateTime dataInizio, LocalDateTime dataFine) {
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
	public LocalDateTime getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(LocalDateTime dataInizio) {
		this.dataInizio = dataInizio;
	}
	public LocalDateTime getDataFine() {
		return dataFine;
	}
	public void setDataFine(LocalDateTime dataFine) {
		this.dataFine = dataFine;
	}
	@Override
	public String toString() {
		return "DataEvento [idDataEvento=" + idDataEvento + ", dataInizio=" + dataInizio + ", dataFine=" + dataFine
				+ "]";
	}
	
	
	@ManyToOne
    @JoinColumn(name = "fk_id_evento", referencedColumnName = "id_evento")
    @JsonIgnoreProperties("dataEventi")
	
	private Evento evento;
	
	public Evento getEvento() {
		return evento;
	}
	public void setLuogo(Evento evento) {
		this.evento=evento;
	}
	
	
	@OneToMany( mappedBy = "dataEvento")
    @JsonIgnoreProperties("dataEvento")
	
	private List<SettoreDataEvento> settoreDataEventi;
		
	public List<SettoreDataEvento> getSettoreDataEventi() {
		return settoreDataEventi;
	}
	public void setSettoreDataEventi(List<SettoreDataEvento> settoreDataEventi) {
		this.settoreDataEventi=settoreDataEventi;
	}
	
	
	
}
