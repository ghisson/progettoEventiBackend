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

import com.example.progettoEventi.model.DataEvento;
import com.example.progettoEventi.model.Errore;
import com.example.progettoEventi.repository.DataEventoRepository;

@Controller
@RequestMapping(path="/dataEvento")
public class DataEventoController {
	@Autowired
	private DataEventoRepository dataEventoRepository;
	
	@CrossOrigin(origins="*")
	@GetMapping("/getDataEvento/{id}")
	public ResponseEntity<Object> getDataEvento(@PathVariable long id) {
		Errore error=new Errore();
		Optional<DataEvento> dtEvt = dataEventoRepository.findById(id);
		if(dtEvt.isPresent()) {
			return new ResponseEntity<Object>(dtEvt.get(), HttpStatus.OK);
		}
		error.setError("DataEvento non trovato");
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}
	

}
