package ro.ubb.catalog.core.service;

import ro.ubb.catalog.core.model.entities.Customer;

import java.util.List;
import java.util.Set;

public interface CustomerService {
    List<Customer> getAllCustomers();

    Customer saveCustomer(Customer customer);

    Customer updateCustomer(Long Id, Customer customer);

    void deleteById(Long id);

    public Set<Customer> filterCustomersByName(String name);
}
