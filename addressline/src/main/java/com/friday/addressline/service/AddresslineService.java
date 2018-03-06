package com.friday.addressline.service;

import com.friday.addressline.model.Address;

/**
 * Service responsible to manage data from addresses
 *
 */
public interface AddresslineService {

	/**
	 * Separates a concatenated street into several fields and group it in a streetName and a streetNumber
	 *
	 * @param concatenatedStreet
	 * @return Address object
	 */
	public Address separateFields(String concatenatedStreet);
	
}
