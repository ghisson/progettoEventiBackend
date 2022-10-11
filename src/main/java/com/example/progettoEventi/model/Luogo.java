package com.example.progettoEventi.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Luogo {
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
		return "Luogo [idLuogo=" + idLuogo + ", nomeLuogo=" + nomeLuogo + ", ubicazione=" + ubicazione + "]";
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

}
