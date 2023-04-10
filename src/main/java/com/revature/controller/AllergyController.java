package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dto.AllergyDto;
import com.revature.service.AllergyService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
//@EnableDiscoveryClient
@RequestMapping("api/v1")
public class AllergyController {
	@Autowired
	private AllergyService allergyService;

	@GetMapping("/allergy")
	public ResponseEntity<List<AllergyDto>> getAllAllergies() {
		List<AllergyDto> allergies = null;
		allergies = allergyService.allAllergies();
		if (allergies == null || allergies.isEmpty())

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		else
//		log.info("AllergyController getAll() response{}",allergies);
			return new ResponseEntity<>(allergies, HttpStatus.OK);
	}

	@GetMapping("/allergy/{id}")
	public ResponseEntity<AllergyDto> getAllergy(@PathVariable int id) {
		AllergyDto allergy = allergyService.getAllergyById(id);
		if (allergy == null)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		else
//		log.info("AllergyController getAllergy() response{}",allergy);
			return new ResponseEntity<>(allergy, HttpStatus.OK);

	}
}
