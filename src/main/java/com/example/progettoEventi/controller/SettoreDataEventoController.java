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
import com.example.progettoEventi.model.SettoreDataEvento;
import com.example.progettoEventi.repository.SettoreDataEventoRepository;
import com.example.progettoEventi.repository.SettoreRepository;

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
			 return new ResponseEntity<Object>(set.get(),HttpStatus.OK);
		 }
		 error.setError("settore data evento non trovato");
		 return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}

}
