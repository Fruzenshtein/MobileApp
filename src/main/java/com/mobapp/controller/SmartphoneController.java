package com.mobapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mobapp.model.Smartphone;
import com.mobapp.service.SmartphoneService;

@Controller
@RequestMapping(value="/smartphones")
public class SmartphoneController {
	
	@Autowired
	private SmartphoneService smartphoneService;
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public ModelAndView createSmartphonePage() {
		ModelAndView mav = new ModelAndView("phones/new-phone");
		mav.addObject("sPhone", new Smartphone());
		return mav;
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ModelAndView createSmartphone(@ModelAttribute Smartphone smartphone,
			final RedirectAttributes attributes) {
		ModelAndView mav = new ModelAndView("redirect:/index.html");
		createSmartphone(smartphone);
		attributes.addFlashAttribute("msg", "New Smartphone "+smartphone+" was successfully created.");
		return mav;
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST, 
			produces = "application/json", consumes = "application/json")
	@ResponseBody
	public Smartphone createSmartphone(@RequestBody Smartphone smartphone) {
		return smartphoneService.create(smartphone);
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editSmartphonePage(@PathVariable int id) {
		ModelAndView mav = new ModelAndView("phones/edit-phone");
		Smartphone smartphone = smartphoneService.get(id);
		mav.addObject("sPhone", smartphone);
		return mav;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.PUT, 
			produces = "application/json", consumes = "application/json")
	@ResponseBody
	public Smartphone editSmartphone(@PathVariable int id, 
			@RequestBody Smartphone smartphone) {
		smartphone.setId(id);
		return smartphoneService.update(smartphone);
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.PUT)
	public ModelAndView editSmartphone(@PathVariable int id,
			@ModelAttribute Smartphone smartphone,
			final RedirectAttributes attributes) {
		ModelAndView mav = new ModelAndView("redirect:/index.html");
		editSmartphone(id, smartphone);
		attributes.addFlashAttribute("msg", "The Smartphone "+smartphone+" was successfully updated.");
		return mav;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE, 
			produces = "application/json", consumes = "application/json")
	@ResponseBody
	public Smartphone deleteSmartphone(@PathVariable int id) {
		return smartphoneService.delete(id);
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteSmartphone(@PathVariable int id,
			final RedirectAttributes attributes) {
		ModelAndView mav = new ModelAndView("redirect:/index.html");
		Smartphone deletedSphone = deleteSmartphone(id);
		attributes.addFlashAttribute("msg", "The Smartphone "+deletedSphone+" was successfully deleted.");
		return mav;
	}
	
	@RequestMapping(value="", method=RequestMethod.GET,
			produces = "application/json", consumes = "application/json")
	@ResponseBody
	public List<Smartphone> allPhones() {
		return smartphoneService.getAll();
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public ModelAndView allPhonesPage() {
		ModelAndView mav = new ModelAndView("phones/all-phones");
		List<Smartphone> smartphones = new ArrayList<Smartphone>();
		smartphones.addAll(allPhones());
		mav.addObject("smartphones", smartphones);
		return mav;
	}
	
}
