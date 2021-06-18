package com.edu.iua.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edu.iua.business.IHistoricoRegistroBusiness;
import com.edu.iua.business.IRegistroBusiness;
import com.edu.iua.business.exception.BusinessException;
import com.edu.iua.business.exception.NotFoundException;
import com.edu.iua.model.Registro;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = Constantes.URL_REGISTROS)
public class RegistroRestController {
	@Autowired
	private IRegistroBusiness registroBusiness;
	@Autowired
	private IHistoricoRegistroBusiness historicoRegistroBusiness;
	
	@PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> add(@RequestBody Registro registro) {
		try {
			Registro r=registroBusiness.cargar(registro);
			historicoRegistroBusiness.add(r);
			
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set("location", Constantes.URL_REGISTROS + "/" + registro.getId());
			return new ResponseEntity<String>(responseHeaders, HttpStatus.CREATED);
		} catch (BusinessException e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Registro>> load() {
		try {
			return new ResponseEntity<List<Registro>>(registroBusiness.list(), HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<List<Registro>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}



}
