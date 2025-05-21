package org.springframework.samples.petclinic.controller;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.samples.petclinic.model.PetDetails;
import org.springframework.samples.petclinic.service.PetDetailsService;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.util.Optional;


@WebMvcTest(PetDetailsController.class)
public class PetDetailsControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PetDetailsService service;

	@Test
	public void shouldReturnPetDetailsOnGet() throws Exception {
		PetDetails details = new PetDetails();
		details.setId(1L);
		details.setTemperament("Friendly");

		when(service.getByPetId(1)).thenReturn(Optional.of(details));

		mockMvc.perform(get("/api/v1/pet-details/1"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.temperament").value("Friendly"));
	}

	@Test
	public void shouldSavePetDetailsOnPost() throws Exception {
		PetDetails details = new PetDetails();
		details.setId(1L);
		details.setTemperament("Loyal");
		details.setWeight(12.0);
		details.setLength(45.0);

		when(service.save(any(PetDetails.class))).thenReturn(details);

		String jsonBody = """
                {
                  "temperament": "calm",
                  "weight": 12.0,
                  "length": 45.0
                }
                """;

		mockMvc.perform(post("/api/v1/pet-details")
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.temperament").value("calm"));
	}
}
