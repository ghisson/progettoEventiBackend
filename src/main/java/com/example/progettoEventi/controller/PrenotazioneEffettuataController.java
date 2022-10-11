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
import com.example.progettoEventi.model.PrenotazioneEffettuata;
import com.example.progettoEventi.repository.PrenotazioneEffettuataRepository;
@Controller
@RequestMapping(path="/prenotazioneEffettuata")
public class PrenotazioneEffettuataController {
	@Autowired
	private PrenotazioneEffettuataRepository prenotazioneEffettuataRepository;
	
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

}
