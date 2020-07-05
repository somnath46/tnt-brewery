package com.tnt.brewery.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.tnt.brewery.model.BeerDto;
import com.tnt.brewery.model.CustomerDto;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public CustomerDto getCustomerById(UUID customerId) {
		return CustomerDto.builder().id(customerId).name("John").build();
	}
	
	@Override
	public CustomerDto create(CustomerDto customerDto) {
		return CustomerDto.builder().id(customerDto.getId()).build();
	}

	@Override
	public void update(UUID customerId, CustomerDto customerDto) {
		// TODO write some implementation later
	}

	@Override
	public void delete(UUID customerId) {
		// TODO write some implementation later
	}


}
