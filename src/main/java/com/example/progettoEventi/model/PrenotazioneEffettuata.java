package com.example.progettoEventi.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class PrenotazioneEffettuata implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id_prenotazione_effettuata")
	private long idPrenotazioneEffettuata;
	@Column(name = "data_prenotazione")
	private LocalDateTime dataPrenotazione;
	@Column(name = "nome_luogo")
	private String nomeLuogo;
	@Column(name = "ubicazione")
	private String ubicazione;
	@Column(name = "nome_settore")
	private String nomeSettore;
	@Column(name = "categoria_evento")
	private String categoriaEvento;
	@Column(name = "autori_evento")
	private String autoriEvento;
	@Column(name = "data_inizio")
	private LocalDateTime dataInizio;
	@Column(name = "data_fine")
	private LocalDateTime dataFine;
	@Column(name = "posti_prenotati")
	private int postiPrenotati;
	@Column(name = "prezzo_biglietto")
	private double prezzoBiglietto;
	@Column(name = "recensione", nullable=true)
	private String recensione;
	@Column(name = "voto_recensione", nullable=true)
	private Integer votoRecensione;
	@Column(name = "numero_carta")
	private String numeroCarta;
	@Column(name = "cvv_carta")
	private int cvvCarta;
	@Column(name = "data_scadenza")
	private LocalDate dataScadenza;
	@Column(name = "intestatario_carta")
	private String intestatarioCarta;
	//fk_settore_data_evento
	//fk_id_utente
	
	public PrenotazioneEffettuata() {}

	public PrenotazioneEffettuata(long idPrenotazioneEffettuata, LocalDateTime dataPrenotazione, String nomeLuogo,
			String ubicazione, String nomeSettore, String categoriaEvento, String autoriEvento, LocalDateTime dataInizio,
			LocalDateTime dataFine, int postiPrenotati, double prezzoBiglietto, String recensione, Integer votoRecensione,
			String numeroCarta, int cvvCarta, LocalDate dataScadenza, String intestatarioCarta) {
		super();
		this.idPrenotazioneEffettuata = idPrenotazioneEffettuata;
		this.dataPrenotazione = dataPrenotazione;
		this.nomeLuogo = nomeLuogo;
		this.ubicazione = ubicazione;
		this.nomeSettore = nomeSettore;
		this.categoriaEvento = categoriaEvento;
		this.autoriEvento = autoriEvento;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.postiPrenotati = postiPrenotati;
		this.prezzoBiglietto = prezzoBiglietto;
		this.recensione = recensione;
		this.votoRecensione = votoRecensione;
		this.numeroCarta = numeroCarta;
		this.cvvCarta = cvvCarta;
		this.dataScadenza = dataScadenza;
		this.intestatarioCarta = intestatarioCarta;
	}

	public long getIdPrenotazioneEffettuata() {
		return idPrenotazioneEffettuata;
	}

	public void setIdPrenotazioneEffettuata(long idPrenotazioneEffettuata) {
		this.idPrenotazioneEffettuata = idPrenotazioneEffettuata;
	}

	public LocalDateTime getDataPrenotazione() {
		return dataPrenotazione;
	}

	public void setDataPrenotazione(LocalDateTime dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
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

	public String getNomeSettore() {
		return nomeSettore;
	}

	public void setNomeSettore(String nomeSettore) {
		this.nomeSettore = nomeSettore;
	}

	public String getCategoriaEvento() {
		return categoriaEvento;
	}

	public void setCategoriaEvento(String categoriaEvento) {
		this.categoriaEvento = categoriaEvento;
	}

	public String getAutoriEvento() {
		return autoriEvento;
	}

	public void setAutoriEvento(String autoriEvento) {
		this.autoriEvento = autoriEvento;
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

	public int getPostiPrenotati() {
		return postiPrenotati;
	}

	public void setPostiPrenotati(int postiPrenotati) {
		this.postiPrenotati = postiPrenotati;
	}

	public double getPrezzoBiglietto() {
		return prezzoBiglietto;
	}

	public void setPrezzoBiglietto(double prezzoBiglietto) {
		this.prezzoBiglietto = prezzoBiglietto;
	}

	public String getRecensione() {
		return recensione;
	}

	public void setRecensione(String recensione) {
		this.recensione = recensione;
	}

	public Integer getVotoRecensione() {
		return votoRecensione;
	}

	public void setVotoRecensione(Integer votoRecensione) {
		this.votoRecensione = votoRecensione;
	}

	public String getNumeroCarta() {
		return numeroCarta;
	}

	public void setNumeroCarta(String numeroCarta) {
		this.numeroCarta = numeroCarta;
	}

	public int getCvvCarta() {
		return cvvCarta;
	}

	public void setCvvCarta(int cvvCarta) {
		this.cvvCarta = cvvCarta;
	}

	public LocalDate getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(LocalDate dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public String getIntestatarioCarta() {
		return intestatarioCarta;
	}

	public void setIntestatarioCarta(String intestatarioCarta) {
		this.intestatarioCarta = intestatarioCarta;
	}
	
	@ManyToOne
    @JoinColumn(name = "fk_id_utente", referencedColumnName = "id_utente")
    @JsonIgnoreProperties("prenotazioniEffettuate")
	
	private Utente utente;
	
	public Utente getUtente() {
		return utente;
	}
	
	public void setUtente(Utente utente) {
		this.utente=utente;
	}
	
	@OneToMany( mappedBy = "prenotazioneEffettuata" )
    @JsonIgnoreProperties("prenotazioneEffettuata")
	
	private List<UtenteInvitato> utentiInvitati;
		
	public List<UtenteInvitato> getUtentiInvitati() {
		return utentiInvitati;
	}
	public void setUtentiInvitati(List<UtenteInvitato> utentiInvitati) {
		this.utentiInvitati=utentiInvitati;
	}
	
	
	@ManyToOne
    @JoinColumn(name = "fk_settore_data_evento", referencedColumnName = "id_settore_data_evento")
    @JsonIgnoreProperties("prenotazioneEffettuata")
	
	private SettoreDataEvento settoreDataEvento;
	
	public SettoreDataEvento getSettoreDataEvento() {
		return settoreDataEvento;
	}
	public void setSettoreDataEvento(SettoreDataEvento settoreDataEvento) {
		this.settoreDataEvento=settoreDataEvento;
	}
	
	
}
