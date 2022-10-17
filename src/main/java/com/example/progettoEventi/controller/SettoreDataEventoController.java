package com.example.progettoEventi.controller;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
import com.example.progettoEventi.model.Filtro;
import com.example.progettoEventi.model.PrenotazioneEffettuata;
import com.example.progettoEventi.model.SettoreDataEvento;
import com.example.progettoEventi.model.Utente;
import com.example.progettoEventi.repository.DataEventoRepository;
import com.example.progettoEventi.repository.SettoreDataEventoRepository;
import com.example.progettoEventi.repository.SettoreRepository;
import java.sql.Date;
import java.time.LocalDateTime;



@Controller
@RequestMapping(path="/settoreDataEvento")
public class SettoreDataEventoController {
	
	@Autowired
	private SettoreDataEventoRepository settoreDataEventoRepository;
	
	
	
	@CrossOrigin(origins ="*")
	@GetMapping("/getSettoreDataEvento/{id}")
	public ResponseEntity<Object> getSettore(@PathVariable long id){
		Errore error=new Errore();
		Optional<SettoreDataEvento> set= settoreDataEventoRepository.findById(id);
		 if (set.isPresent()) {
			 int postiOccupati=0;
			 LocalDateTime now = LocalDateTime.now(); 
			 SettoreDataEvento settoreDataEvento= set.get();
				
				if(settoreDataEvento.getPrenotazioniEffettuate().size()>0) {
					for(PrenotazioneEffettuata pr:settoreDataEvento.getPrenotazioniEffettuate()) {
						postiOccupati+=pr.getPostiPrenotati();
					}
					//System.out.println(postiOccupati+" "+settoreDataEvento.getDataEvento().getEvento().getNomeEvento());
				}
				if(postiOccupati>=settoreDataEvento.getSettore().getNumeroPosti()) {
					error.setError("non ci sono più posti disponibili");
					return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
				}if(settoreDataEvento.getDataEvento().getDataFine().isBefore(now)) {
					error.setError("l'evento per cui stai prenotando è già passato");
					 return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
				}
				else {
					
					settoreDataEvento.setPostiDisponibili(settoreDataEvento.getSettore().getNumeroPosti()-postiOccupati);
				}
			 return new ResponseEntity<Object>(settoreDataEvento,HttpStatus.OK);
		 }
		 error.setError("settore data evento non trovato");
		 return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}
	
	
	@CrossOrigin(origins ="*")
	@GetMapping("/getAll")
	public ResponseEntity<List<SettoreDataEvento>> getAllSettoreDataEvento(){
		
		List<SettoreDataEvento> ret=settoreDataEventoRepository.findAll();
		
		ret=ret.stream().sorted((o1, o2)->o1.getDataEvento().getDataInizio().compareTo(o2.getDataEvento().getDataInizio())).
                collect(Collectors.toList());		 
		return new ResponseEntity<List<SettoreDataEvento>>(ret, HttpStatus.OK);
	}
	
	
	@CrossOrigin(origins ="*")
	@GetMapping("/getAllActive")
	public ResponseEntity<List<SettoreDataEvento>> getAllSettoreDataEventoActive(){

		int postiOccupati=0;
		
		List<SettoreDataEvento> ret=settoreDataEventoRepository.findAll();
		List<SettoreDataEvento> eventiPassati=new ArrayList<SettoreDataEvento>();
		LocalDateTime now = LocalDateTime.now(); 		
		for(SettoreDataEvento settoreDataEvento:ret) {
			//check dei posti disponibili
			postiOccupati=0;
			
			if(settoreDataEvento.getPrenotazioniEffettuate().size()>0) {
				for(PrenotazioneEffettuata pr:settoreDataEvento.getPrenotazioniEffettuate()) {
					postiOccupati+=pr.getPostiPrenotati();
				}
				//System.out.println(postiOccupati+" "+settoreDataEvento.getDataEvento().getEvento().getNomeEvento());
			}
			if(postiOccupati>=settoreDataEvento.getSettore().getNumeroPosti()) {
				eventiPassati.add(settoreDataEvento);
			}else {
				/*
				 * bisogna aggiungere una variabile che dice i posti disponibili
				 * 
				 */
				settoreDataEvento.setPostiDisponibili(settoreDataEvento.getSettore().getNumeroPosti()-postiOccupati);
			}
			//fine
			
			if(settoreDataEvento.getDataEvento().getDataFine().isBefore(now)) {
				eventiPassati.add(settoreDataEvento);
			}
		}
		ret.removeAll(eventiPassati);
		ret=ret.stream().sorted((o1, o2)->o1.getDataEvento().getDataInizio().compareTo(o2.getDataEvento().getDataInizio())).
                collect(Collectors.toList());
		return new ResponseEntity<List<SettoreDataEvento>>(ret, HttpStatus.OK);
	}
	
	
	@CrossOrigin(origins ="*")
	@PostMapping("/getAllByFilter")
	public ResponseEntity<List<SettoreDataEvento>> getAllByFilter(@RequestBody Filtro filtro){
		
		
		int postiOccupati=0;
		List<SettoreDataEvento> ret=settoreDataEventoRepository.findAll();
		List<SettoreDataEvento> eventiPassati=new ArrayList<SettoreDataEvento>();
		List<SettoreDataEvento> eventiByFilter;

		LocalDateTime now = LocalDateTime.now(); 		
		for(SettoreDataEvento settoreDataEvento:ret) {
		
			//check dei posti disponibili
			postiOccupati=0;
			
			if(settoreDataEvento.getPrenotazioniEffettuate().size()>0) {
				for(PrenotazioneEffettuata pr:settoreDataEvento.getPrenotazioniEffettuate()) {
					postiOccupati+=pr.getPostiPrenotati();
				}
				//System.out.println(postiOccupati+" "+settoreDataEvento.getDataEvento().getEvento().getNomeEvento());
			}
			if(postiOccupati>=settoreDataEvento.getSettore().getNumeroPosti()) {
				eventiPassati.add(settoreDataEvento);
			}else {
				
				settoreDataEvento.setPostiDisponibili(settoreDataEvento.getSettore().getNumeroPosti()-postiOccupati);
			}
			//fine
			
			
			//RIMOZIONE EVENTI PASSATI
			if(settoreDataEvento.getDataEvento().getDataFine().isBefore(now)) {
				eventiPassati.add(settoreDataEvento);
			}
		}
		ret.removeAll(eventiPassati);
		
		
		//filtro by autore
		if(!filtro.getAutore().equals("")) {
			eventiByFilter=new ArrayList<SettoreDataEvento>();
			for(SettoreDataEvento settoreDataEvento:ret) {
				if(!settoreDataEvento.getDataEvento().getEvento().getAutoreEvento().toLowerCase().equals(filtro.getAutore().toLowerCase())) {
					eventiByFilter.add(settoreDataEvento);
				}
			}
			ret.removeAll(eventiByFilter);
		}
		
		//filtro by categoria
		if(!filtro.getCategoria().equals("")) {
			eventiByFilter=new ArrayList<SettoreDataEvento>();
			for(SettoreDataEvento settoreDataEvento:ret) {
				if(!settoreDataEvento.getDataEvento().getEvento().getCategoriaEvento().equals(filtro.getCategoria())) {
					eventiByFilter.add(settoreDataEvento);
				}
			}
			ret.removeAll(eventiByFilter);
		}
		
		//filtro by datainizio
		if(filtro.getDataInizio() != null) {
			eventiByFilter=new ArrayList<SettoreDataEvento>();
			for(SettoreDataEvento settoreDataEvento:ret) {
				if(settoreDataEvento.getDataEvento().getDataInizio().toLocalDate().isBefore(filtro.getDataInizio())) {
					eventiByFilter.add(settoreDataEvento);
				}
			}
			ret.removeAll(eventiByFilter);
		}
		
		//filtro by datafine
		if(filtro.getDataFine() != null) {
			eventiByFilter=new ArrayList<SettoreDataEvento>();
			for(SettoreDataEvento settoreDataEvento:ret) {
				if(settoreDataEvento.getDataEvento().getDataInizio().toLocalDate().isAfter(filtro.getDataFine())) {
					eventiByFilter.add(settoreDataEvento);
				}
			}
			ret.removeAll(eventiByFilter);
		}
		
		
		ret=ret.stream().sorted((o1, o2)->o1.getDataEvento().getDataInizio().compareTo(o2.getDataEvento().getDataInizio())).
                collect(Collectors.toList());
		return new ResponseEntity<List<SettoreDataEvento>>(ret, HttpStatus.OK);
	}
	
	

}
