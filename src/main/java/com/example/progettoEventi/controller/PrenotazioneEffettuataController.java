package com.example.progettoEventi.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

import com.example.progettoEventi.model.DataEvento;
import com.example.progettoEventi.model.Errore;
import com.example.progettoEventi.model.Evento;
import com.example.progettoEventi.model.PrenotazioneEffettuata;
import com.example.progettoEventi.model.SettoreDataEvento;
import com.example.progettoEventi.model.SupportoPrenotazione;
import com.example.progettoEventi.model.SupportoRecensione;
import com.example.progettoEventi.model.Utente;
import com.example.progettoEventi.model.UtenteInvitato;
import com.example.progettoEventi.repository.DataEventoRepository;
import com.example.progettoEventi.repository.EventoRepository;
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
	
	@Autowired
	private EventoRepository eventoRepository;
	
	@Autowired
	private DataEventoRepository dataEventoRepository;
	
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
	@GetMapping("/getPrenotazioneEffettuataByIdEvento/{idEvento}")
	public ResponseEntity<Object> getPrenotazioneEffettuataByIdEvento(@PathVariable long idEvento){
		Errore error=new Errore();
		Optional<Evento> evento=eventoRepository.findById(idEvento);
		Set<SettoreDataEvento> settoreDataEvento = new HashSet<>();
		
		Set<PrenotazioneEffettuata> prenEff =  new HashSet<>();
		Evento evt;
		if(evento.isPresent()) {
			evt=evento.get();
			List<DataEvento> dataEvento=dataEventoRepository.findByEvento(evt);
			if(dataEvento.size()>0) {
				for(DataEvento dtEvt : dataEvento) {
					settoreDataEvento.addAll(settoreDataEventoRepository.findByDataEvento(dtEvt));
					if(settoreDataEvento.size()>0) {
						for(SettoreDataEvento settDtEvt: settoreDataEvento) {
							prenEff.addAll(prenotazioneEffettuataRepository.findBySettoreDataEvento(settDtEvt));
						}
					}
				}
				
			}
		}
		List<PrenotazioneEffettuata> prenotazioneEffettuata = new ArrayList<>(prenEff);
		return new ResponseEntity<Object>(prenotazioneEffettuata, HttpStatus.OK);
	}
	
	
	
	@CrossOrigin(origins="*")
	@PostMapping("/addRecensione/{id}")
	public ResponseEntity<Object> addRecensione(@RequestBody SupportoRecensione recensione, @PathVariable long id){
		Errore error=new Errore();
		PrenotazioneEffettuata pre;
		Optional<PrenotazioneEffettuata> prtEftt= prenotazioneEffettuataRepository.findById(id);
		if(prtEftt.isPresent()) {
			pre=prtEftt.get();
			pre.setRecensione(recensione.getRecensione());
			pre.setVotoRecensione(recensione.getVotoRecensione());
			prenotazioneEffettuataRepository.save(pre);
			return new ResponseEntity<Object>(pre, HttpStatus.OK);
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
		return new ResponseEntity<Object>(supPren, HttpStatus.OK);

	}

}
