package com.example.progettoEventi.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Utente {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_utente")
	private long idUtente;

	private String nome;

	private String cognome;
  
	private String genere;
  
	private String email;

	private String password;
	
	private Date data_di_nascita;
	
	private String luogo_di_nascita;
	
	@Column(name = "codice_fiscale") 
	private String codiceFiscale;
	
	
	public Utente() {}
	
	

	public Utente(long idUtente, String nome, String cognome, String genere, String email, String password,
			Date data_di_nascita, String luogo_di_nascita, String codice_fiscale) {
		super();
		this.idUtente = idUtente;
		this.nome = nome;
		this.cognome = cognome;
		this.genere = genere;
		this.email = email;
		this.password = password;
		this.data_di_nascita = data_di_nascita;
		this.luogo_di_nascita = luogo_di_nascita;
		this.codiceFiscale = codice_fiscale;
	}



	public Date getData_di_nascita() {
		return data_di_nascita;
	}




	public void setData_di_nascita(Date data_di_nascita) {
		this.data_di_nascita = data_di_nascita;
	}


	public String getLuogo_di_nascita() {
		return luogo_di_nascita;
	}



	public void setLuogo_di_nascita(String luogo_di_nascita) {
		this.luogo_di_nascita = luogo_di_nascita;
	}


	public String getCodice_fiscale() {
		return codiceFiscale;
	}



	public void setCodice_fiscale(String codice_fiscale) {
		this.codiceFiscale = codice_fiscale;
	}

	public long getIdUtente() {
		return idUtente;
	}
	
	public void setIdUtente(long idUtente) {
		this.idUtente = idUtente;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public String getGenere() {
		return genere;
	}
	
	public void setGenere(String genere) {
		this.genere = genere;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "Utente [idUtente=" + idUtente + ", nome=" + nome + ", cognome=" + cognome + ", genere=" + genere
				+ ", email=" + email + ", password=" + password + ", data_di_nascita=" + data_di_nascita
				+ ", luogo_di_nascita=" + luogo_di_nascita + ", codice_fiscale=" + codiceFiscale + "]";
	}

 
	
  
}
