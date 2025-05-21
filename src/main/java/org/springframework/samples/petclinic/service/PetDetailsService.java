package org.springframework.samples.petclinic.service;

import org.springframework.samples.petclinic.model.PetDetails;
import org.springframework.samples.petclinic.repository.PetDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PetDetailsService {

	PetDetailsRepository petDetailsRepository;

	public PetDetailsService(PetDetailsRepository petDetailsRepository) {
		this.petDetailsRepository = petDetailsRepository;
	}

	public PetDetails save(PetDetails details) {
		return petDetailsRepository.save(details);
	}

	public Optional<PetDetails> getByPetId(Integer petId) {
		return petDetailsRepository.findByPetId(petId);
	}
}
