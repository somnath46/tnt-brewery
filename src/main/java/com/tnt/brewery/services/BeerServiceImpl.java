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

	@Override
	public BeerDto create(BeerDto beerDto) {
		return BeerDto.builder().id(beerDto.getId()).build();
	}

	@Override
	public void update(UUID beerId, BeerDto beerDto) {
		// TODO write some implementation later
	}

	@Override
	public void delete(UUID beerId) {
		// TODO write some implementation later
	}
}
