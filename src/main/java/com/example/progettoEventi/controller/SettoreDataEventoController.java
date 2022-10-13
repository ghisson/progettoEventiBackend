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
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.progettoEventi.model.Errore;
import com.example.progettoEventi.model.SettoreDataEvento;
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
			 return new ResponseEntity<Object>(set.get(),HttpStatus.OK);
		 }
		 error.setError("settore data evento non trovato");
		 return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}
	
	
	@CrossOrigin(origins ="*")
	@GetMapping("/getAll")
	public ResponseEntity<List<SettoreDataEvento>> getAllSettoreDataEvento(){
		
		List<SettoreDataEvento> ret=settoreDataEventoRepository.findAll();
		
		 Collections.sort(ret, (o1, o2) -> o1.getDataEvento().getDataInizio().compareTo(o2.getDataEvento().getDataInizio()));
		 
		return new ResponseEntity<List<SettoreDataEvento>>(ret, HttpStatus.OK);
	}
	
	
	@CrossOrigin(origins ="*")
	@GetMapping("/getAllActive")
	public ResponseEntity<List<SettoreDataEvento>> getAllSettoreDataEventoActive(){
		
		List<SettoreDataEvento> ret=settoreDataEventoRepository.findAll();
		List<SettoreDataEvento> eventiPassati=new ArrayList<SettoreDataEvento>();
		LocalDateTime now = LocalDateTime.now(); 		
		for(SettoreDataEvento settoreDataEvento:ret) {
			if(settoreDataEvento.getDataEvento().getDataFine().isBefore(now)) {
				eventiPassati.add(settoreDataEvento);
			}
		}
		ret.removeAll(eventiPassati);
		Collections.sort(ret, (o1, o2) -> o1.getDataEvento().getDataInizio().compareTo(o2.getDataEvento().getDataInizio()));
		return new ResponseEntity<List<SettoreDataEvento>>(ret, HttpStatus.OK);
	}

}
