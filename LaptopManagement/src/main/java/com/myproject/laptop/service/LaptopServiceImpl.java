package com.myproject.laptop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.myproject.laptop.entity.Laptop;
import com.myproject.laptop.repository.JDBCRepository;
import com.myproject.laptop.repository.LaptopRepository;

@Service
public class LaptopServiceImpl implements LaptopService{
	
	@Autowired
	private LaptopRepository repo;
	
	@Autowired
	private JDBCRepository jdbc;

	@Override
	public List<Laptop> getAllLaptops() {
		// TODO Auto-generated method stub
		return jdbc.getLaps();
	}

	@Override
	public String deleteById(Long id) {
		// TODO Auto-generated method stub
		repo.findById(id).orElseThrow();
		repo.deleteById(id);
		return "Deleted successfully";
	}

	@Override
	public Laptop addLaptop(Laptop lap) {
		// TODO Auto-generated method stub
		return repo.save(lap);
	}

	@Override
	
	public String update(Long id, Laptop lap) {
		// TODO Auto-generated method stub
		Laptop existingLaptop=repo.findById(id).orElseThrow();
		existingLaptop.setBrand(lap.getBrand());
		existingLaptop.setModel(lap.getModel());
		existingLaptop.setPrice(lap.getPrice());
		existingLaptop.setRam(lap.getRam());
		
		repo.save(existingLaptop);
		
		return "Updated Successfully";
	}

	@Override
	public Laptop getLaptopById(Long id) {
		// TODO Auto-generated method stub
		Optional<Laptop> lap=repo.findById(id);
		Laptop l=new Laptop();
		if(lap.isPresent()) {
			l=lap.get();
		}
		return l;
	}

}
