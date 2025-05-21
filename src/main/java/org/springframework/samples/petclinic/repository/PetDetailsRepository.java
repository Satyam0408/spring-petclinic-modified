package org.springframework.samples.petclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.petclinic.model.PetDetails;

import java.util.Optional;

public interface PetDetailsRepository extends JpaRepository<PetDetails, Long> {
	Optional<PetDetails> findByPetId(Integer petId);
}


