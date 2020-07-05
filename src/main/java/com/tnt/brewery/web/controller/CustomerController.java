package com.tnt.brewery.web.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tnt.brewery.model.BeerDto;
import com.tnt.brewery.model.CustomerDto;
import com.tnt.brewery.services.CustomerService;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/{customerId}")
	public ResponseEntity<CustomerDto> getCustomer(@PathVariable UUID customerId) {
		return new ResponseEntity<CustomerDto>(customerService.getCustomerById(customerId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity createBear(@RequestBody final CustomerDto customerDto) {
		final CustomerDto savedDto = customerService.create(customerDto);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("x-tnt-localtion", "/api/v1/customer/" + savedDto.getId().toString());

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@PutMapping("/{customerId}")
	public ResponseEntity updateBear(@PathVariable final UUID customerId, @RequestBody final CustomerDto customerDto) {
		customerService.update(customerId, customerDto);
		
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/{customerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBear(@PathVariable final UUID customerId) {
		customerService.delete(customerId);
	}
}
