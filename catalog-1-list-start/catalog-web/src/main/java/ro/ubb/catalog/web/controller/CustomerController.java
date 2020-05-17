package ro.ubb.catalog.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.catalog.core.service.CustomerService;
import ro.ubb.catalog.web.converter.CustomerConverter;
import ro.ubb.catalog.web.dto.CustomerDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class CustomerController {
    public static final Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerConverter customerConverter;

    @RequestMapping(value="/customers", method = RequestMethod.GET)
    List<CustomerDto> getCustomers(){
        log.trace("/customers GET - method entered:");
        return new ArrayList<>(customerConverter.convertModelsToDtos(customerService.getAllCustomers()));
    }

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    CustomerDto saveCustomer(@RequestBody CustomerDto customerDto) {
        log.trace("/customers POST - method entered: customerDto={}", customerDto);
        return customerConverter.convertModelToDto(customerService.saveCustomer(
                customerConverter.convertDtoToModel(customerDto)
        ));
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.PUT)
    CustomerDto updateCustomer(@PathVariable Long id,
                             @RequestBody CustomerDto customerDto) {
        log.trace("/customers PUT - method entered: id={} customerDto={}", id, customerDto);
        return customerConverter.convertModelToDto( customerService.updateCustomer(id,
                customerConverter.convertDtoToModel(customerDto)));
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteCustomer(@PathVariable Long id){
        log.trace("/customers POST - method entered: id={}", id);
        customerService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @RequestMapping(value = "/customers/{name}", method = RequestMethod.GET)
//    List<CustomerDto> filterCustomersByName(@PathVariable String name){
//        log.trace("/customers POST - method entered: name={}", name);
//        return new customerConverter;
//    }
}
