package ro.ubb.catalog.core.model.entities;


import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
public class Rental extends BaseEntity<Long>{
//    private Long customerId;
//    private Long movieId;

    @ManyToOne
    @JoinColumn(name= "customerId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    Customer customer;

    @ManyToOne
    @JoinColumn(name= "movieId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    Movie movie;
}
