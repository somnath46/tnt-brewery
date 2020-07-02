package com.tnt.brewery.services;

import java.util.UUID;

import com.tnt.brewery.model.CustomerDto;

public interface CustomerService {

	public CustomerDto getCustomerById(UUID customerId);
}
