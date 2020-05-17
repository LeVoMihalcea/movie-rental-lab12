package ro.ubb.catalog.core.model.entities;


import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@Transactional
public class Movie extends BaseEntity<Long>{
    private String title;
    private int yearOfRelease;

//    @OneToMany(mappedBy = "movie")
//    Set<Rental> rentals;
}
