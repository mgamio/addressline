package com.friday.addressline.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.friday.addressline.model.Address;

public class AddresslineServiceImplTest {

	private AddresslineServiceImpl addresslineService;

	@Before
	public void setup() {
		addresslineService = new AddresslineServiceImpl();
	}
	
	@Test
	public void whenSpacesThenReturnStringSplited( ) {
		
		String concatenatedStreet = "Winterallee 3";
		
		Address address = addresslineService.separateFields(concatenatedStreet);
		assertEquals("Winterallee", address.getStreetName());
		
	}
	
}
