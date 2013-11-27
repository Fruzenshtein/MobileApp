package com.mobapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mobapp.exception.SmartphoneNotFoundException;
import com.mobapp.model.Smartphone;
import com.mobapp.repository.SmartphoneRepository;

@Service
@Transactional(rollbackFor = { SmartphoneNotFoundException.class })
public class SmartphoneServiceImpl implements SmartphoneService {
	
	@Autowired
	private SmartphoneRepository smartphoneRepository;

	@Override
	public Smartphone create(Smartphone sp) {
		return smartphoneRepository.save(sp);
	}

	@Override
	public Smartphone get(Integer id) {
		Smartphone sp = null;
		if (id instanceof Integer)
			sp = smartphoneRepository.findOne(id);
		if (sp != null)
			return sp;
		throw new SmartphoneNotFoundException(id);
	}

	@Override
	public List<Smartphone> getAll() {
		return smartphoneRepository.findAll();
	}

	@Override
	public Smartphone update(Smartphone sp) {
		Smartphone sPhoneToUpdate = get(sp.getId());
		sPhoneToUpdate.update(sp);
		return sPhoneToUpdate;
	}

	@Override
	public Smartphone delete(Integer id) {
		Smartphone sPhone = get(id);
		smartphoneRepository.delete(id);
		return sPhone;
	}

}
