package com.sip.ams.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	    @ApiResponse(responseCode = "404", description = "Provider non trouvé")
	})
	public List<Provider> getAllProviders()
	{
		return (List<Provider>)providerRepository.findAll();
	}
	
	
	@PostMapping("/")
	public Provider saveProvider(@RequestBody Provider p)
	{
		
		return providerRepository.save(p);
	}
	

}
