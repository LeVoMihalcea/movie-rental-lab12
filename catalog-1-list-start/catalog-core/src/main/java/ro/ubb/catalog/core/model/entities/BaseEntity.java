package ro.ubb.catalog.core.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

// A mapped superclass has no separate table defined for it.
@MappedSuperclass
// will generate a constructor with no parameters.
@NoArgsConstructor
// will generate a constructor with all parameters
@AllArgsConstructor
// getters and setters
@Data
public abstract class BaseEntity<ID extends Serializable> implements Serializable {
    @Id
    @GeneratedValue
    private ID id;


}
