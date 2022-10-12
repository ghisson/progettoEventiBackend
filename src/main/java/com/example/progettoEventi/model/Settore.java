package com.example.progettoEventi.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Settore implements Serializable {
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
				+ ", luogo=" + luogo + "]";
	}
	
	/*
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="fk_id_luogo")
	*/
	
	@OneToMany( mappedBy = "settore")
    @JsonIgnoreProperties("settore")
	
	private List<SettoreDataEvento> settoreDataEventi;
		
	public List<SettoreDataEvento> getSettoreDataEventi() {
		return settoreDataEventi;
	}
	public void setSettoreDataEventi(List<SettoreDataEvento> settoreDataEventi) {
		this.settoreDataEventi=settoreDataEventi;
	}


	@ManyToOne
    @JoinColumn(name = "fk_id_luogo", referencedColumnName = "id_luogo")
    @JsonIgnoreProperties("settori")
	
	private Luogo luogo;
	
	public Luogo getLuogo() {
		return luogo;
	}
	public void setLuogo(Luogo luogo) {
		this.luogo=luogo;
	}

	
}
