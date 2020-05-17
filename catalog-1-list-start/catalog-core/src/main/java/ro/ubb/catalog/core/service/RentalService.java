package ro.ubb.catalog.core.service;


import ro.ubb.catalog.core.model.entities.Rental;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface RentalService {
    List<Rental> getAllRentals();

    Rental saveRental(Rental movie);

    void deleteById(Long id);

//    public HashMap<Long, Integer> getStat(boolean reverse);
}
