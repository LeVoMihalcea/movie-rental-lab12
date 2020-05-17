package ro.ubb.catalog.web.dto;

import lombok.*;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.catalog.core.model.entities.Customer;
import ro.ubb.catalog.core.model.entities.Movie;
import ro.ubb.catalog.core.model.entities.Rental;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@Transactional
public class RentalDto extends BaseDto {
    private Customer customer;
    private Movie movie;
}
