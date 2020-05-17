package ro.ubb.catalog.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.catalog.core.model.entities.Customer;
import ro.ubb.catalog.core.model.validators.CustomerValidator;
import ro.ubb.catalog.core.repository.CustomerRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CustomerServiceImpl implements CustomerService {
    public static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerValidator customerValidator;



    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    @Transactional
    public Customer saveCustomer(Customer customer) {
        log.trace("saveCustomer - method entered: customer={}", customer);
        this.customerValidator.validate(customer);
        log.trace("saveCustomer - customer validated: customer={}", customer);
        log.trace("saveCustomer - saving customer - finishing method after saving: customer={}", customer);
        return customerRepository.save(customer);
    }

    @Override
    @Transactional
    public Customer updateCustomer(Long id,Customer customer) {
        customer.setId(id);
        this.customerValidator.validate(customer);
        log.trace("updateCustomer - method entered: customer={}", customer);
        Customer fromRepo = customerRepository.findById(customer.getId()).orElse(customer);
        fromRepo.setName(customer.getName());

        log.trace("updateCustomer - method finished, returning");
        return fromRepo;
    }

    @Override
    public Set<Customer> filterCustomersByName(String name) {
        log.trace("filterCustomersByName - method entered: name={}", name);
        Iterable<Customer> movies = customerRepository.findAll();
        Set<Customer> filteredCustomers = new HashSet<>();
        movies.forEach(filteredCustomers::add);
        filteredCustomers.removeIf(customer -> !customer.getName().contains(name));
        log.trace("filterCustomersByName - method finished: name={}", name);
        return filteredCustomers;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        log.trace("deleteById - method finished: id={}", id);
        customerRepository.findById(id).ifPresent(
                x -> {
                    customerRepository.deleteById(id);
                    log.trace("deleteById - deleted Customer: id={}", id);
                }
        );
        log.trace("deleteById - method finished: id={}", id);
    }
}
