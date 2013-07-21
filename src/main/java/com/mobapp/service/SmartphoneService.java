package com.mobapp.service;

import java.util.List;

import com.mobapp.exception.SmartphoneNotFoundException;
import com.mobapp.model.Smartphone;

public interface SmartphoneService {
	
	public Smartphone create(Smartphone sp);
	public Smartphone get(Integer id);
	public List<Smartphone> getAll();
	public Smartphone update(Smartphone sp) throws SmartphoneNotFoundException;
	public Smartphone delete(Integer id) throws SmartphoneNotFoundException;

}
