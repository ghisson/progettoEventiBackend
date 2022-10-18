package com.example.progettoEventi.controller;

import java.sql.SQLException;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.progettoEventi.model.Errore;
import com.example.progettoEventi.model.PrenotazioneEffettuata;
import com.example.progettoEventi.model.SettoreDataEvento;
import com.example.progettoEventi.model.Utente;
import com.example.progettoEventi.model.UtenteLogin;
import com.example.progettoEventi.repository.UtenteRepository;

@Controller // This means that this class is a Controller
@RequestMapping(path="/utente") // This means URL's start with /utente (after Application path)
public class UtenteController {
  @Autowired // This means to get the bean called userRepository
         // Which is auto-generated by Spring, we will use it to handle the data
  private UtenteRepository utenteRepository;
  
  

  @CrossOrigin(origins = "*")
  @PostMapping("/addUtente")
  public ResponseEntity<Object> postBody(@RequestBody Utente utente) {
	  
	
      Errore errore=new Errore();
	  
      Optional<Utente> ut=utenteRepository.findByCodiceFiscale(utente.getCodice_fiscale());
	  if(ut.isPresent()) {
		  errore.setError("codice fiscale già inserito");
		  return new ResponseEntity<Object>(errore,HttpStatus.BAD_REQUEST);
	  }
	  
	  ut=utenteRepository.findByEmail(utente.getEmail());
	  if(ut.isPresent()) {
		  errore.setError("email già inserita");
		  return new ResponseEntity<Object>(errore,HttpStatus.BAD_REQUEST);
	  }
	  
	  utenteRepository.save(utente);
	  return new ResponseEntity<Object>(utente,HttpStatus.OK);
  }
  
  
  @CrossOrigin(origins ="*")
  @GetMapping("/getUtente/{id}")
	public ResponseEntity<Object> getUtente(@PathVariable long id){
		Errore error=new Errore();
		Utente utente;
		List<PrenotazioneEffettuata>pre=new ArrayList<>();
		Optional<Utente> ut= utenteRepository.findById(id);
		 if (ut.isPresent()) {
			 utente=ut.get();
			 pre=utente.getPrenotazioniEffettuate();
			 pre=pre.stream().sorted((o1, o2)->o1.getSettoreDataEvento().getDataEvento().getDataInizio().compareTo(o2.getSettoreDataEvento().getDataEvento().getDataInizio())).
		                collect(Collectors.toList());
			 utente.setPrenotazioniEffettuate(pre);
			
			 return new ResponseEntity<Object>(utente,HttpStatus.OK);
		 }
		 error.setError("utente non trovato");
		 return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}

  @CrossOrigin(origins = "*")
  @PostMapping("/login")
  public ResponseEntity<Object> postLogin(@RequestBody UtenteLogin user) {
      Errore errore=new Errore();
      Optional<Utente> ut=utenteRepository.findByEmail(user.getEmail());
      if (ut.isPresent()) {
    	  Utente utn = ut.get();
    	  if(utn.getPassword().equals(user.getPassword())) {
    		  return new ResponseEntity<Object>(utn,HttpStatus.OK);
    	  }
    	 errore.setError("password non corretta per email associata");
 		 return new ResponseEntity<Object>(errore, HttpStatus.BAD_REQUEST);
      } 
      errore.setError("email non presente");
      return new ResponseEntity<Object>(errore, HttpStatus.BAD_REQUEST);
      
  }
}




































