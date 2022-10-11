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
import com.example.progettoEventi.model.Settore;
import com.example.progettoEventi.repository.SettoreRepository;

@Controller
@RequestMapping(path="/settore")
public class SettoreController {
	@Autowired
	private SettoreRepository settoreRepository;
	
	@CrossOrigin(origins ="*")
	@GetMapping("/getSettore/{id}")
	public ResponseEntity<Object> getSettore(@PathVariable long id){
		Errore error=new Errore();
		Optional<Settore> set= settoreRepository.findById(id);
		 if (set.isPresent()) {
			 return new ResponseEntity<Object>(set.get(),HttpStatus.OK);
		 }
		 error.setError("settore non trovato");
		 return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}

}
