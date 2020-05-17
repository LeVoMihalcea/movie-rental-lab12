package ro.ubb.catalog.core.model.validators;


import org.springframework.stereotype.Component;
import ro.ubb.catalog.core.model.entities.Movie;
import ro.ubb.catalog.core.model.exceptions.ValidatorException;

@Component
public class MovieValidator implements Validator<Movie> {
    @Override
    public void validate(Movie entity) throws ValidatorException {
        if(entity.getTitle().isEmpty() || entity.getTitle() == null) throw new ValidatorException("Name cannot be empty!");
        if(entity.getYearOfRelease() < 1800) throw new ValidatorException("Cameras were not invented back then!");
        if(entity.getYearOfRelease() > 2020) throw new ValidatorException("Are you from the future?");
    }
}
