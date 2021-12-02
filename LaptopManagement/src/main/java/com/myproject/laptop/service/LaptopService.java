package com.myproject.laptop.service;

import java.util.List;

import com.myproject.laptop.entity.Laptop;

public interface LaptopService {
	
	List<Laptop> getAllLaptops();
	String deleteById(Long id);
	Laptop addLaptop(Laptop lap);
	String update(Long id, Laptop lap);
	Laptop getLaptopById(Long id);

}
