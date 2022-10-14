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
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.progettoEventi.model.Errore;
import com.example.progettoEventi.model.Evento;
import com.example.progettoEventi.model.SettoreDataEvento;
import com.example.progettoEventi.repository.EventoRepository;
@Controller
@RequestMapping(path="/evento")
public class EventoController {
	@Autowired
	private EventoRepository eventoRepository;
	
	
	@CrossOrigin(origins="*")
	@GetMapping("/getEvento/{id}")
	public ResponseEntity<Object> getEvento(@PathVariable long id){
		Errore error= new Errore();
		Optional<Evento> event=eventoRepository.findById(id);
		if(event.isPresent()) {

			return new ResponseEntity<Object>(event.get(), HttpStatus.OK);
		}
		error.setError("evento non trovato");
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}
	
	
	@CrossOrigin(origins="*")
	@GetMapping("/getAllCategorie")
	public ResponseEntity<List<String>> getAllCategorie(){
		List<Evento> eventi=eventoRepository.findAll();
		Set<String> categorie = new HashSet<>();
		for(Evento x:eventi) {
			categorie.add(x.getCategoriaEvento());
		}
		 List<String> ret = new ArrayList<>(categorie);
		
		return new ResponseEntity<List<String>>(ret, HttpStatus.OK);
	}	
	
	
	
	

}
