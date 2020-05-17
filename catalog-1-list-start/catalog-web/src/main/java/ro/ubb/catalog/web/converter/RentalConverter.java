package ro.ubb.catalog.web.converter;

import org.springframework.stereotype.Component;
import ro.ubb.catalog.core.model.entities.Rental;
import ro.ubb.catalog.web.dto.RentalDto;

@Component
public class RentalConverter extends BaseConverter<Rental, RentalDto> {
    @Override
    public Rental convertDtoToModel(RentalDto dto) {
        Rental rental = Rental.builder()
                .customer(dto.getCustomer())
                .movie(dto.getMovie())
                .build();
        rental.setId(dto.getId());
        return rental;
    }

    @Override
    public RentalDto convertModelToDto(Rental rental) {
        RentalDto dto = RentalDto.builder()
                .customer(rental.getCustomer())
                .movie(rental.getMovie())
                .build();
        dto.setId(rental.getId());
        return dto;
    }
}
