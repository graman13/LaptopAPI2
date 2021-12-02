package com.myproject.laptop.controller;

import com.myproject.laptop.entity.Laptop;
import com.myproject.laptop.service.LaptopServiceImpl;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController

public class LaptopController {


	private LaptopServiceImpl service;
	public LaptopController(LaptopServiceImpl service) {
		this.service = service;
	}

	@GetMapping(value="/laptops",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public List<Laptop> getAllLaptops(){
		return service.getAllLaptops();
	}
	
	@GetMapping(value="/laptopslist",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public List<Laptop> getListLaptops(){
		return service.getAllLaptops();
	}
	
	@GetMapping(value="/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public EntityModel<Laptop> getById(@PathVariable Long id) {
		Laptop lap = service.getLaptopById(id);
		
		return EntityModel.of(lap, (new Link("http://localhost:8080/people")));
		
	}
	
	@PostMapping(value="/addlaptop",consumes = MediaType.APPLICATION_JSON_VALUE)
	public Laptop addLaptop(@Valid @RequestBody Laptop laptop, BindingResult bindingResult) {
		if(bindingResult.hasErrors()){
			throw new NullPointerException();
		}
		 return service.addLaptop(laptop);
	}
	
	@GetMapping(value="/delete/{id}")
	public String deleteById(@PathVariable Long id) {
		
		return service.deleteById(id);
	}
	
	@PutMapping("/update/{id}")
	
	public String update(@PathVariable("id") Long id,@RequestBody Laptop lap) {
		return service.update(id,lap);

	}
	
	
}
