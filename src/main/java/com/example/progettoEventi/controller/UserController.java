package com.example.progettoEventi.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.progettoEventi.model.Errore;
import com.example.progettoEventi.model.Utente;
import com.example.progettoEventi.repository.UserRepository;

@Controller // This means that this class is a Controller
@RequestMapping(path="/utente") // This means URL's start with /demo (after Application path)
public class UserController {
  @Autowired // This means to get the bean called userRepository
         // Which is auto-generated by Spring, we will use it to handle the data
  private UserRepository userRepository;
  
  

  @CrossOrigin(origins = "*")
  @PostMapping("/addUtente")
  public ResponseEntity<Object> postBody(@RequestBody Utente utente) {
	  
	
      Errore errore=new Errore();
	  
	  Utente ut=userRepository.findByCodiceFiscale(utente.getCodice_fiscale());
	  if(ut!=null) {
		  errore.setError("codice fiscale già inserito");
		  return new ResponseEntity<Object>(errore,HttpStatus.BAD_REQUEST);
	  }
	  
	  ut=userRepository.findByEmail(utente.getEmail());
	  if(ut!=null) {
		  errore.setError("email già inserita");
		  return new ResponseEntity<Object>(errore,HttpStatus.BAD_REQUEST);
	  }
	  
	  userRepository.save(utente);
	  
	 
	  
	  return new ResponseEntity<Object>(utente,HttpStatus.OK);
  }


}