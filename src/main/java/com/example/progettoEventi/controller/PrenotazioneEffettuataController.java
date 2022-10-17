package com.example.progettoEventi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.progettoEventi.model.Errore;
import com.example.progettoEventi.model.PrenotazioneEffettuata;
import com.example.progettoEventi.model.SettoreDataEvento;
import com.example.progettoEventi.model.SupportoPrenotazione;
import com.example.progettoEventi.model.Utente;
import com.example.progettoEventi.model.UtenteInvitato;
import com.example.progettoEventi.repository.PrenotazioneEffettuataRepository;
import com.example.progettoEventi.repository.SettoreDataEventoRepository;
import com.example.progettoEventi.repository.UtenteInvitatoRepository;
import com.example.progettoEventi.repository.UtenteRepository;
@Controller
@RequestMapping(path="/prenotazioneEffettuata")
public class PrenotazioneEffettuataController {
	@Autowired
	private PrenotazioneEffettuataRepository prenotazioneEffettuataRepository;
	
	@Autowired 
	private UtenteRepository utenteRepository;
	
	@Autowired
	private SettoreDataEventoRepository settoreDataEventoRepository;
	
	@Autowired
	private UtenteInvitatoRepository utenteInvitatoRepository;
	
	@CrossOrigin(origins="*")
	@GetMapping("/getPrenotazioneEffettuata/{id}")
	public ResponseEntity<Object> getPrenotazioneEffettuata(@PathVariable long id){
		Errore error=new Errore();
		Optional<PrenotazioneEffettuata> prtEftt= prenotazioneEffettuataRepository.findById(id);
		if(prtEftt.isPresent()) {
			return new ResponseEntity<Object>(prtEftt.get(), HttpStatus.OK);
		}
		error.setError("PrenotazioneEffettuata non trovata");
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}
	
	
	@CrossOrigin(origins="*")
	@PostMapping("/addPrenotazioneEffettuata")
	public ResponseEntity<Object> addPrenotazioneEffettuata(@RequestBody SupportoPrenotazione supPren ){
		
		Errore errore=new Errore();
		
		Optional<SettoreDataEvento> set= settoreDataEventoRepository.findById(supPren.getIdSettoreDataEvento());
		SettoreDataEvento sde;
		
		Optional<Utente> uto= utenteRepository.findById(supPren.getIdUtente());
		Utente ut;
		
		UtenteInvitato ui;

		if(set.isPresent() && uto.isPresent()) {
			ut=uto.get();
			sde=set.get();
			PrenotazioneEffettuata pe=new PrenotazioneEffettuata(sde,supPren,ut);
			prenotazioneEffettuataRepository.save(pe);
			
			for(int i=0;i<supPren.getUtentiInvitati().length;i++) {
				ui=new UtenteInvitato(supPren.getUtentiInvitati()[i],pe);
				utenteInvitatoRepository.save(ui);
				
			}
			
		}else {
			errore.setError("Utente o SettoreDataEvento non trovati");
			return new ResponseEntity<Object>(errore, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Object>("ciao", HttpStatus.OK);

	}

}
