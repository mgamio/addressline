package com.friday.addressline.service;

import org.springframework.stereotype.Service;

import com.friday.addressline.model.Address;

import java.util.StringTokenizer;

@Service
public class AddresslineServiceImpl implements AddresslineService {

	private static final String SEPARATOR_COMMA = ",";

	@Override
	public Address separateFields(String concatenatedStreet) {
		
		Address address = new Address();

		StringTokenizer tokensOfFields;

		if (concatenatedStreet.contains(SEPARATOR_COMMA)) {
			tokensOfFields = new StringTokenizer(concatenatedStreet, SEPARATOR_COMMA);
		} else {
			tokensOfFields = new StringTokenizer(concatenatedStreet);
		}

		while(tokensOfFields.hasMoreElements()) {
			String field = tokensOfFields.nextToken().trim();
			if (Character.isDigit(field.charAt(0))) {
				address.setStreetNumber(field);
			} else {
				address.setStreetName(field);
			}
		}

		return address;
	}

	
}
