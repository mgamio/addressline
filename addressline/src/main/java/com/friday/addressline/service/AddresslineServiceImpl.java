package com.friday.addressline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friday.addressline.model.Address;

import java.util.StringTokenizer;

@Service
public class AddresslineServiceImpl implements AddresslineService {

	private static final String SEPARATOR_COMMA = ",";
	private static final String SPACE = " ";

	private Address address;

	@Autowired
	public AddresslineServiceImpl(Address address) {
		this.address = address;
	}

	@Override
	public Address separateFields(String concatenatedStreet) {

		StringTokenizer tokensOfFields;

		if (concatenatedStreet.contains(SEPARATOR_COMMA)) {
			tokensOfFields = new StringTokenizer(concatenatedStreet, SEPARATOR_COMMA);
		} else {
			tokensOfFields = new StringTokenizer(concatenatedStreet); //Space by default
		}

		StringBuilder fieldsOfName = new StringBuilder();
		StringBuilder fieldsOfNumber = new StringBuilder();

		int counter = 0;
		boolean firstOccurrenceForName = false;

		while(tokensOfFields.hasMoreElements()) {
			counter++;
			String field = tokensOfFields.nextToken().trim();
			if (Character.isDigit(field.charAt(0))) {
				fieldsOfNumber.append((field + SPACE));
			} else {
				if (firstOccurrenceForName & fieldsOfNumber.length() > 0) {
				  fieldsOfNumber.append((field + SPACE));
				} else {
					fieldsOfName.append(field + SPACE);
					if (counter == 1)
						firstOccurrenceForName = true;
				}
			}
		}

		address.setStreetName(fieldsOfName.toString().trim());
		address.setStreetNumber(fieldsOfNumber.toString().trim());

		return address;

	}

	
}
