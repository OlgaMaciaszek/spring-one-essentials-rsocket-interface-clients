package com.example.spring.one.essentials.customerservice;

import java.util.UUID;

/**
 * @author Olga Maciaszek-Sharma
 */

public interface CustomerRepository {

	Customer create(Customer customer);

	Customer get(UUID id);

}
