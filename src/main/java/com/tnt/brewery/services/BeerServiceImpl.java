package com.tnt.brewery.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.tnt.brewery.model.BeerDto;

@Service
public class BeerServiceImpl implements BeerService {

	@Override
	public BeerDto getBeerById(UUID beerId) {
		return BeerDto.builder().id(beerId).beerName("Tuborg").build();
	}

}
