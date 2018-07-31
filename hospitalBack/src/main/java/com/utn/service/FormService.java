package com.utn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.utn.modelo.Paciente;
import com.utn.repository.IPacienteRepository;

@RestController
public class FormService {
	@Autowired
	private IPacienteRepository paciente;
	@Autowired
	private Gson gson;
	
	
	@GetMapping(value="getPrueba")
	public String Prueba() {
		return "Prueba";
		
	}
	
	@CrossOrigin
	@GetMapping(value="getPaciente/{id}")
	public ResponseEntity getPacienteById(@PathVariable("id")Integer id) {
		return ResponseEntity.ok(gson.toJson(paciente.findById(id)));
	}
	
	
	@CrossOrigin
	@PostMapping(value="guardar")
	public ResponseEntity<Paciente> guardarPaciente(@RequestBody Paciente pac){
		paciente.save(pac);
		
		return new ResponseEntity<Paciente>(HttpStatus.OK);
	}

}
