package ro.ubb.catalog.core.model.validators;


import org.springframework.stereotype.Component;
import ro.ubb.catalog.core.model.entities.Rental;
import ro.ubb.catalog.core.model.exceptions.ValidatorException;

@Component
public class RentalValidator implements Validator<Rental> {
    @Override
    public void validate(Rental entity) {
        return;
    }
}
