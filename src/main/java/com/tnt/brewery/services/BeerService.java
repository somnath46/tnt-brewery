package com.tnt.brewery.services;

import java.util.UUID;

import com.tnt.brewery.model.BeerDto;

public interface BeerService {

	public BeerDto getBeerById(UUID beerId);

	public BeerDto create(BeerDto beerDto);

	public void update(UUID beerId, BeerDto beerDto);

	public void delete(UUID beerId);
}
