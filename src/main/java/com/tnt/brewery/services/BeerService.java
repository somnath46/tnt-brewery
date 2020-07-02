package com.tnt.brewery.services;

import java.util.UUID;

import com.tnt.brewery.model.BeerDto;

public interface BeerService {

	public BeerDto getBeerById(UUID beerId);
}
