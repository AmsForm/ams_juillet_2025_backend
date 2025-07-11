package com.sip.ams.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sip.ams.entities.Provider;
import com.sip.ams.repositories.ProviderRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
@RestController
@RequestMapping("providers")
public class ProviderController {
	
	@Autowired
	ProviderRepository providerRepository;
	
	@GetMapping("/")
	@Operation(summary = "Récupération de tous les providers")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Succès de get All"),
	    @ApiResponse(responseCode = "500", description = "Problème lors de la récupération")
	})
	public ResponseEntity<List<Provider>> getAllProviders()
	{
		return new ResponseEntity<>((List<Provider>)providerRepository.findAll(),HttpStatus.CREATED);
	}
	
	
	@PostMapping("/")
	@Operation(summary = "Ajout d'un nouvel provider")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "201", description = "Insertion avec succès"),
	    @ApiResponse(responseCode = "500", description = "Problème lors de l'insertion")
	})
	public  ResponseEntity<Provider> saveProvider(@RequestBody Provider p)
	{
		return new ResponseEntity<>(providerRepository.save(p),  HttpStatus.CREATED);
	}
	

}
