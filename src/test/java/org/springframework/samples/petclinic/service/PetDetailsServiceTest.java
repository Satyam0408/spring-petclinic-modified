package org.springframework.samples.petclinic.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.petclinic.model.PetDetails;
import org.springframework.samples.petclinic.repository.PetDetailsRepository;

import java.util.Optional;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PetDetailsServiceTest {

	@Mock
	private PetDetailsRepository repository;

	@InjectMocks
	private PetDetailsService service;

	@Test
	public void shouldSavePetDetails() {
		PetDetails details = new PetDetails();
		details.setTemperament("calm");
		details.setWeight(10.5);
		details.setLength(30.0);

		when(repository.save(any(PetDetails.class))).thenReturn(details);

		PetDetails saved = service.save(details);

		assertNotNull(saved);
		assertEquals("calm", saved.getTemperament());
		verify(repository, times(1)).save(any(PetDetails.class));
	}

	@Test
	public void shouldReturnPetDetailsById() {
		PetDetails details = new PetDetails();
		details.setId(1L);
		details.setTemperament("calm");

		when(repository.findById(1L)).thenReturn(Optional.of(details));

		Optional<PetDetails> byPetId = service.getByPetId(1);

		assertEquals("calm", byPetId.get().getTemperament());
		verify(repository).findById(1L);
	}
}
