package com.demo.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.demo.repository.RegistartionRepository;

import jakarta.annotation.Resource;
@Scope("singleton")

@Service
public class RegistrationService {
	private static final Logger LOG=LoggerFactory.getLogger(RegistrationService.class);
	@Autowired
	private RegistartionRepository repostiory;
	@Autowired
	private RegistartionRepository repostiory1;
//	@Qualifier("kartikRepository")
//	@Autowired
	@Resource(name="kartikRepository")
	private MyService service;
	
	public void doRegistration() {
//		System.out.println("do Registration method started");
		service.test();
		LOG.info("do Registration method started");
		LOG.info("repository {} repository1 {}",repostiory.hashCode(), repostiory1.hashCode());
		System.out.println(repostiory.hashCode());
		System.out.println(repostiory1.hashCode());
		repostiory.save();
	} 
}
