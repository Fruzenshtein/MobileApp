package com.mobapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mobapp.model.Smartphone;

public interface SmartphoneRepository extends JpaRepository<Smartphone, Integer>{

}
