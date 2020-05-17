package ro.ubb.catalog.core.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.ubb.catalog.core.model.entities.Customer;
import ro.ubb.catalog.core.model.entities.Rental;
import ro.ubb.catalog.core.model.validators.RentalValidator;
import ro.ubb.catalog.core.repository.CustomerRepository;
import ro.ubb.catalog.core.repository.MovieRepository;
import ro.ubb.catalog.core.repository.RentalRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RentalServiceImpl implements RentalService {
    public static final Logger log = LoggerFactory.getLogger(RentalServiceImpl.class);
    @Autowired
    private RentalRepository rentalRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private CustomerRepository customerRepository;

    private RentalValidator rentalValidator = new RentalValidator();


    @Override
    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    @Override
    public Rental saveRental(Rental rental) {
        log.trace("saveRental - method entered: Rental={}", rental);
        this.rentalValidator.validate(rental);
        log.trace("saveRental - Rental validated: Rental={}", rental);
        log.trace("saveRental - saving rental - method finishing after repository save: Rental={}", rental);
        return rentalRepository.save(rental);

    }

    @Override
    public void deleteById(Long id) {
        log.trace("deleteById - method finished: id={}", id);
        rentalRepository.findById(id).ifPresent(s -> {
            rentalRepository.deleteById(id);
            log.trace("deleteById - deleted Rental: id={}", id);
        });
        log.trace("deleteById - method finished: id={}", id);
    }


//    @Override
//    public HashMap<Long, Integer> getStat(boolean reverse) {
//        log.trace("deleteById - method entered: reverse={}", reverse);
//        List<Rental> rentals = this.getAllRentals();
//        Iterable<Customer> customers = this.customerRepository.findAll();
//        HashMap<Long, Integer> stats = new HashMap<>();
//        log.trace("deleteById - got all rentals and customers: reverse={}", reverse);
//        for(Customer c: customers){
//            if(!stats.containsKey(c.getId())){
//                stats.put(c.getId(), 0);
//            }
//            for(Rental r: rentals){
//                if(r.getCustomerId().equals(c.getId())){
//                    stats.put(c.getId(),
//                            (int) rentals.stream().filter(z -> z.getCustomerId().equals(c.getId())).count());
//
//                }
//            }
//        }
//        log.trace("deleteById - populated the stats, returning: reverse={}", reverse);
//        if(reverse){
//            return stats.entrySet().stream()
//                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
//                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
//        }
//        else{
//            return stats.entrySet().stream()
//                    .sorted(Map.Entry.comparingByValue())
//                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
//        }
//
//    }
}
