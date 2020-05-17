package ro.ubb.catalog.web.converter;

import org.springframework.stereotype.Component;
import ro.ubb.catalog.core.model.entities.Customer;
import ro.ubb.catalog.web.dto.CustomerDto;

@Component
public class CustomerConverter extends BaseConverter<Customer, CustomerDto> {
    @Override
    public Customer convertDtoToModel(CustomerDto dto) {
        Customer customer = Customer.builder()
                .name(dto.getName())
                .build();
        customer.setId(dto.getId());
        return customer;
    }

    @Override
    public CustomerDto convertModelToDto(Customer customer) {
        CustomerDto dto = CustomerDto.builder()
                .name(customer.getName())
                .build();
        dto.setId(customer.getId());
        return dto;
    }
}
