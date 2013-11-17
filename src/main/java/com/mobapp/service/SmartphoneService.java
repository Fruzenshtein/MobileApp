package com.mobapp.service;

import java.util.List;

import com.mobapp.exception.SmartphoneNotFoundException;
import com.mobapp.model.Smartphone;

public interface SmartphoneService {
	
	public Smartphone create(Smartphone sp);
	public Smartphone get(Integer id) throws SmartphoneNotFoundException;
	public List<Smartphone> getAll();
	public Smartphone update(Smartphone sp);
	public Smartphone delete(Integer id);

}
