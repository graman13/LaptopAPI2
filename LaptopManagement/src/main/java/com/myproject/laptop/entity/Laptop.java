package com.myproject.laptop.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Laptop {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotNull
	@Size(max = 10, min = 2)
	@NotEmpty
	private String brand;
	private String model;
	private double price;
	@NotNull
	@NotEmpty
	private String ram;


	
	public Laptop() {
		super();
	}
	public Laptop(String brand, String model, double price, String ram) {
		super();
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.ram = ram;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}

}
