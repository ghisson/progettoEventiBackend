package com.example.progettoEventi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.progettoEventi.model.Errore;
import com.example.progettoEventi.model.Prenotazione;
import com.example.progettoEventi.repository.PrenotazioneRepository;
@Controller
@RequestMapping(path="/prenotazione")
public class PrenotazioneController {
	@Autowired
	private PrenotazioneRepository prenotazioneRepository;
	
	@CrossOrigin(origins ="*")
	@GetMapping("/getPrenotazione/{id}")
	public ResponseEntity<Object> getSettore(@PathVariable long id){
		Errore error=new Errore();
		Optional<Prenotazione> prt= prenotazioneRepository.findById(id);
		if(prt.isPresent()) {
			return new ResponseEntity<Object>(prt.get(), HttpStatus.OK);
		}
		error.setError("Prenotazione non trovata");
		 return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}
}
