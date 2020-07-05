package com.tnt.brewery.web.controller;

import java.util.UUID;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.tnt.brewery.model.BeerDto;
import com.tnt.brewery.services.BeerService;

@WebMvcTest(BeerController.class)
public class BeerControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	BeerService beerService;

	BeerDto beerDto;

	@BeforeEach
	public void init() {
		beerDto = BeerDto.builder()
					.id(UUID.randomUUID())
					.beerName("Kingfisher")
					.beerStyle("Strong")
					.build();
	}

	@AfterEach
	public void cleanUp() {
		Mockito.reset(beerService);
	}
	
	@Test
	public void testGetBeerById() throws Exception {
		BDDMockito.given(beerService.getBeerById(ArgumentMatchers.any()))
			.willReturn(beerDto);
	
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/beer/" + beerDto.getId()))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(beerDto.getId().toString())))
			.andExpect(MockMvcResultMatchers.jsonPath("$.beerName", Matchers.is(beerDto.getBeerName())));
	}
}
