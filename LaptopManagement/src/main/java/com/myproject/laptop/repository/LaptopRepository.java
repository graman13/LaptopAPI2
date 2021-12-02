package com.myproject.laptop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.laptop.entity.Laptop;

public interface LaptopRepository extends JpaRepository<Laptop, Long>{


}
