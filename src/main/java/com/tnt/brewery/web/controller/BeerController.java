package com.tnt.brewery.web.controller;

import java.util.UUID;

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
import com.tnt.brewery.services.BeerService;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
	private BeerService beerService;

	public BeerController(BeerService beerService) {
		this.beerService = beerService;
	}

	@GetMapping("/{beerId}")
	public ResponseEntity<BeerDto> getBeer(@PathVariable final UUID beerId) {
		return new ResponseEntity<BeerDto>(beerService.getBeerById(beerId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity createBear(@RequestBody final BeerDto beerDto) {
		final BeerDto savedDto = beerService.create(beerDto);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("x-tnt-localtion", "/api/v1/beer/" + savedDto.getId().toString());

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@PutMapping("/{beerId}")
	public ResponseEntity updateBear(@PathVariable final UUID beerId, @RequestBody final BeerDto beerDto) {
		beerService.update(beerId, beerDto);
		
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/{beerId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBear(@PathVariable final UUID beerId) {
		beerService.delete(beerId);
	}
}
