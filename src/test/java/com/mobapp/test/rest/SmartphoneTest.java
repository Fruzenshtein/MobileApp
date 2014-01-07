package com.mobapp.test.rest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mobapp.init.WebAppConfig;
import com.mobapp.model.Smartphone;
import com.mobapp.service.SmartphoneService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebAppConfig.class)
@TransactionConfiguration
@WebAppConfiguration
@ActiveProfiles("test")
public class SmartphoneTest {
	
	@Autowired
	private SmartphoneService smartphoneService;
	
	@Test
	public void test() {
		
		Smartphone sp = new Smartphone();
		sp.setModel("N90");
		sp.setPrice(500);
		sp.setProducer("Nokia");
		
		Smartphone newSmartphone = smartphoneService.create(sp);
		
		assertEquals(sp.getProducer(), newSmartphone.getProducer());
		assertEquals(sp.getModel(), newSmartphone.getModel());
		assertTrue(sp.getPrice() == newSmartphone.getPrice());
	}
	
	

}
