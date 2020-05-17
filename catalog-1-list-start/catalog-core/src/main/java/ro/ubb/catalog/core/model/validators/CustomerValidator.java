package ro.ubb.catalog.core.model.validators;


import org.springframework.stereotype.Component;
import ro.ubb.catalog.core.model.entities.Customer;
import ro.ubb.catalog.core.model.exceptions.ValidatorException;

@Component
public class CustomerValidator implements Validator<Customer>{
    @Override
    public void validate(Customer entity) {
        if(entity.getName().isEmpty() || entity.getName() == null) throw new ValidatorException("Name cannot be empty!");
    }
}
