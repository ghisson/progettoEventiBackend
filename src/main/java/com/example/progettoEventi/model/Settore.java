package com.example.progettoEventi.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Settore {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_settore")
	private long idSettore;
	@Column(name = "nome_settore")
	private String nomeSettore;
	@Column(name = "numero_posti")
	private int numeroPosti;
	
	//fk_id_luogo
	
	public Settore() {}
	
	public Settore (long idSettore, String nomeSettore, int numeroPosti) {
		this.idSettore=idSettore;
		this.nomeSettore=nomeSettore;
		this.numeroPosti=numeroPosti;
	}

	public long getIdSettore() {
		return idSettore;
	}

	public void setIdSettore(long idSettore) {
		this.idSettore = idSettore;
	}

	public String getNomeSettore() {
		return nomeSettore;
	}

	public void setNomeSettore(String nomeSettore) {
		this.nomeSettore = nomeSettore;
	}

	public int getNumeroPosti() {
		return numeroPosti;
	}

	public void setNumeroPosti(int numeroPosti) {
		this.numeroPosti = numeroPosti;
	}

	@Override
	public String toString() {
		return "Settore [idSettore=" + idSettore + ", nomeSettore=" + nomeSettore + ", numeroPosti=" + numeroPosti
				+ "]";
	}
}
