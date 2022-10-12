package com.example.progettoEventi.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Evento {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_evento")
	private long idEvento;
	@Column(name="nome_evento")
	private String nomeEvento;
	@Column(name="categoria_evento")
	private String categoriaEvento;
	@Column(name="autore_evento")
	private String autoreEvento;
	@Column(name="descrizione_evento")
	private String descrizioneEvento;
	
	public Evento() {}
	public Evento(long idEvento, String nomeEvento, String categoriaEvento, String autoreEvento, String descrizioneEvento){
		this.idEvento=idEvento;
		this.nomeEvento=nomeEvento;
		this.categoriaEvento=categoriaEvento;
		this.autoreEvento=autoreEvento;
		this.descrizioneEvento=descrizioneEvento;
	}
	public long getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(long idEvento) {
		this.idEvento = idEvento;
	}
	public String getNomeEvento() {
		return nomeEvento;
	}
	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}
	public String getCategoriaEvento() {
		return categoriaEvento;
	}
	public void setCategoriaEvento(String categoriaEvento) {
		this.categoriaEvento = categoriaEvento;
	}
	public String getAutoreEvento() {
		return autoreEvento;
	}
	public void setAutoreEvento(String autoreEvento) {
		this.autoreEvento = autoreEvento;
	}
	public String getDescrizioneEvento() {
		return descrizioneEvento;
	}
	public void setDescrizioneEvento(String descrizioneEvento) {
		this.descrizioneEvento = descrizioneEvento;
	}
	@Override
	public String toString() {
		return "Evento [idEvento=" + idEvento + ", nomeEvento=" + nomeEvento + ", categoriaEvento=" + categoriaEvento
				+ ", autoreEvento=" + autoreEvento + ", descrizioneEvento=" + descrizioneEvento + "]";
	}
	
	@OneToMany( mappedBy = "evento")
    @JsonIgnoreProperties("evento")
	
	private List<DataEvento> dataEventi;
		
	public List<DataEvento> getDataEventi() {
		return dataEventi;
	}
	public void setSettori(List<DataEvento> dataEventi) {
		this.dataEventi=dataEventi;
	}
	
}
