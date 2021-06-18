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
import org.springframework.web.bind.annotation.RestController;

import com.edu.iua.business.IHistoricoRegistroBusiness;
import com.edu.iua.business.IRegistroBusiness;
import com.edu.iua.business.exception.BusinessException;
import com.edu.iua.model.HistoricoRegistro;
import com.edu.iua.model.Registro;

@RestController
@RequestMapping(value = Constantes.URL_HISTORICO_REGISTROS)
public class HistoricoRegistroRestController {

	@Autowired
	private IHistoricoRegistroBusiness historicoRegistroBusiness;
	
	
	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<HistoricoRegistro>> load() {
		try {
			return new ResponseEntity<List<HistoricoRegistro>>(historicoRegistroBusiness.list(), HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<List<HistoricoRegistro>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}



}
