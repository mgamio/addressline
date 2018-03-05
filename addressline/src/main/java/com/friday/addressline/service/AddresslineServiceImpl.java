package com.friday.addressline.service;

import org.springframework.stereotype.Service;

import com.friday.addressline.model.Address;

@Service
public class AddresslineServiceImpl implements AddresslineService {

	@Override
	public Address separateFields(String concatenatedStreet) {
		
		Address address = new Address();
		
		String[] fields = concatenatedStreet.split(" ");
		
		for (String field : fields) {
			
		}
		address.setStreetName(fields[0]);
		address.setStreetNumber(fields[1]);
		
		return address;
	}

	
}
