package com.mobapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="smartphones")
public class Smartphone {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String producer;
	
	private String model;
	
	private double price;
	
	/**
	 * Method updates already existed {@link Smartphone} object with values from the inputed argument.
	 * @param sPhone - Object which contains new Smartphone values.
	 * @return {@link Smartphone} object to which this method applied.
	 */
	public Smartphone update(Smartphone sPhone) {
		this.producer = sPhone.producer;
		this.model = sPhone.model;
		this.price = sPhone.price;
		return this;
	}
	
	@Override
	public String toString() {
		return producer+": "+model+" with price "+price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
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
	
}
