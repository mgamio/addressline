package com.friday.addressline.service;

import com.friday.addressline.model.Address;

public interface AddresslineService {

	public Address separateFields(String concatenatedStreet);
	
}
