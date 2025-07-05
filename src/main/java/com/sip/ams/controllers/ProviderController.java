package com.sip.ams.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sip.ams.entities.Provider;
import com.sip.ams.repositories.ProviderRepository;

@RestController
public class ProviderController {
	
	@Autowired
	ProviderRepository providerRepository;
	
	@GetMapping("/providers")
	public List<Provider> getAllProviders()
	{
		return (List<Provider>)providerRepository.findAll();
	}
	
	
	@PostMapping("/provider")
	public Provider saveProvider()
	{
		Provider p = new Provider("HP","hp@gmail.com","USA");
		return providerRepository.save(p);
	}
	

}
