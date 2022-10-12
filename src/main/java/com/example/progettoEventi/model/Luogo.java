package com.example.progettoEventi.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Luogo implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_luogo")
	private long idLuogo;
	@Column(name = "nome_luogo")
	private String nomeLuogo;
	
	private String ubicazione;
	
	public Luogo() {}
	
	Luogo(long idLuogo, String nomeLuogo, String ubicazione){
		this.idLuogo=idLuogo;
		this.nomeLuogo=nomeLuogo;
		this.ubicazione=ubicazione;
	}

	

	@Override
	public String toString() {
		return "Luogo [idLuogo=" + idLuogo + ", nomeLuogo=" + nomeLuogo + ", ubicazione=" + ubicazione + ", settori="
				+ settori + "]";
	}

	public long getIdLuogo() {
		return idLuogo;
	}

	public void setIdLuogo(long idLuogo) {
		this.idLuogo = idLuogo;
	}

	public String getNomeLuogo() {
		return nomeLuogo;
	}

	public void setNomeLuogo(String nomeLuogo) {
		this.nomeLuogo = nomeLuogo;
	}

	public String getUbicazione() {
		return ubicazione;
	}

	public void setUbicazione(String ubicazione) {
		this.ubicazione = ubicazione;
	}

	
	@OneToMany(mappedBy="luogo")
	private List<Settore> settori;
		
		public List<Settore> getSettori() {
			return settori;
		}
		public void setSettori(List<Settore> settori) {
			this.settori=settori;
		}
	
}
