package ro.ubb.catalog.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.catalog.core.service.RentalService;
import ro.ubb.catalog.web.converter.RentalConverter;
import ro.ubb.catalog.web.dto.CustomerDto;
import ro.ubb.catalog.web.dto.RentalDto;

import java.util.ArrayList;
import java.util.List;


@RestController
public class RentalController {
    public static final Logger log = LoggerFactory.getLogger(RentalController.class);

    @Autowired
    private RentalService rentalService;

    @Autowired
    private RentalConverter rentalConverter;

    @RequestMapping(value="/rentals", method = RequestMethod.GET)
    public List<RentalDto> getRentals(){
        log.trace("/rentals GET - method entered:");
        return new ArrayList<>(rentalConverter.convertModelsToDtos(rentalService.getAllRentals()));
    }

    @RequestMapping(value = "/rentals", method = RequestMethod.POST)
    RentalDto saveStudent(@RequestBody RentalDto rentalDto) {
        log.trace("/rentals POST - method entered: rentalDto={}", rentalDto);

        System.out.println(rentalDto);
        return rentalConverter.convertModelToDto(rentalService.saveRental(
                rentalConverter.convertDtoToModel(rentalDto)
        ));
    }

    @RequestMapping(value = "/rentals/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteStudent(@PathVariable Long id){
        log.trace("/rentals DELETE - method entered: id={} rentalDto={}", id, id);


        rentalService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
