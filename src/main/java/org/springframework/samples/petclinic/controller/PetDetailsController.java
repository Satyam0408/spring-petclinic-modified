package org.springframework.samples.petclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.model.PetDetails;
import org.springframework.samples.petclinic.service.PetDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pet-details")
public class PetDetailsController {

	@Autowired
	private PetDetailsService petDetailsService;

	@PostMapping
	public ResponseEntity<PetDetails> addDetails(@RequestBody PetDetails details) {
		return new ResponseEntity<>(petDetailsService.save(details), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PetDetails> getDetails(@PathVariable Integer id) {
		return petDetailsService.getByPetId(id)
			.map(ResponseEntity::ok)
			.orElse(ResponseEntity.notFound().build());
	}
}
