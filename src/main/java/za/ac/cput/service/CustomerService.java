package za.ac.cput.service;

/**
 * CustomerService.java
 * Author: Lonwabo Sibusisiwe Magazi- 218331851
 * Date: May 2023
 */

import za.ac.cput.domain.impl.Customer;

public interface CustomerService {
    void createCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void deleteCustomer(Customer customer);

    Customer getCustomerById(int customerId);
}
