package com.example.progettoEventi.controller;

import java.sql.SQLException;
import java.util.Optional;

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
import com.example.progettoEventi.model.Settore;
import com.example.progettoEventi.model.Utente;
import com.example.progettoEventi.model.UtenteInvitato;
import com.example.progettoEventi.repository.UtenteInvitatoRepository;

@Controller // This means that this class is a Controller
@RequestMapping(path="/utenteInvitato")
public class UtenteInvitatoController {
	
	@Autowired
	private UtenteInvitatoRepository utenteInvitatoRepository;
	
	@CrossOrigin(origins ="*")
	@GetMapping("/getUtenteInvitato/{id}")
	public ResponseEntity<Object> getUtenteInvitato(@PathVariable long id){
		Errore error=new Errore();
		Optional<UtenteInvitato> ut= utenteInvitatoRepository.findById(id);
		 if (ut.isPresent()) {
			 return new ResponseEntity<Object>(ut.get(),HttpStatus.OK);
		 }
		 error.setError("utente invitato non trovato");
		 return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}

}
