package com.friday.addressline.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.friday.addressline.model.Address;

public class AddresslineServiceImplTest {

	private AddresslineServiceImpl addresslineService;

	@Before
	public void setup() {
		addresslineService = new AddresslineServiceImpl(new Address());
	}
	
	@Test
	public void whenConcatenatedStreetWithSpacesThenReturnFirstPartAsName( ) {
		String concatenatedStreet = "Winterallee 3";
		Address address = addresslineService.separateFields(concatenatedStreet);
		assertEquals("Winterallee", address.getStreetName());
	}

	@Test
	public void whenConcatenatedStreetWithCommaThenReturnSecondPartAsNameAndFirstPartAsNumber( ) {
		String concatenatedStreet = "3a, Winterallee";
		Address address = addresslineService.separateFields(concatenatedStreet);
		assertEquals("Winterallee", address.getStreetName());
		assertEquals("3a", address.getStreetNumber());
	}

	@Test
	public void whenConcatenatedStreetIncludesThreeFieldsThenReturnThirdFieldAsNumber( ) {
		String concatenatedStreet = "Am Bächle 23";
		Address address = addresslineService.separateFields(concatenatedStreet);
		assertEquals("23", address.getStreetNumber());
	}

	@Test
	public void whenConcatenatedStreetIncludesThreeFieldsThenReturnTheTwoFirstsFieldsAsName( ) {
		String concatenatedStreet = "Auf der Vogelwiese 23";
		Address address = addresslineService.separateFields(concatenatedStreet);
		assertEquals("Auf der Vogelwiese", address.getStreetName());
	}

	@Test
	public void whenConcatenatedStreetIncludesThreeFieldsThenReturnTheFirstFieldsAsNumber( ) {
		String concatenatedStreet = "200 Broadway Av";
		Address address = addresslineService.separateFields(concatenatedStreet);
		assertEquals("200", address.getStreetNumber());
	}

	@Test
	public void whenConcatenatedStreetIncludesFiveFieldsThenReturnTheLastTwoFieldsAsNumber( ) {
		String concatenatedStreet = "Auf der Vogelwiese 23 b";
		Address address = addresslineService.separateFields(concatenatedStreet);
		assertEquals("23 b", address.getStreetNumber());
	}


}
