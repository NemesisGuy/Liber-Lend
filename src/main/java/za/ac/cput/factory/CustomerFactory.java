package za.ac.cput.factory;

/**
 * CustomerFactory.java
 * Author: Lonwabo Sibusisiwe Magazi- 218331851
 * Date: May 2023
 */

import za.ac.cput.domain.impl.Customer;

public class CustomerFactory {
    public static Customer createCustomer(int customerId, String firstName, String lastName, String contactInfo, String loanHistory) {
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setContactInfo(contactInfo);
        customer.setLoanHistory(loanHistory);
        return customer;
    }
}

