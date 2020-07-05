package com.tnt.brewery.services;

import java.util.UUID;

import com.tnt.brewery.model.BeerDto;
import com.tnt.brewery.model.CustomerDto;

public interface CustomerService {

	public CustomerDto getCustomerById(UUID customerId);
	
	public CustomerDto create(CustomerDto customerDto);

	public void update(UUID customerId, CustomerDto customerDto);

	public void delete(UUID customerId);

}
