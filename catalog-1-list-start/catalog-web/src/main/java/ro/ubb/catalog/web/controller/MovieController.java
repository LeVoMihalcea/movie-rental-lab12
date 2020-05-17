package ro.ubb.catalog.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ubb.catalog.core.model.exceptions.MovieRentalException;
import ro.ubb.catalog.core.model.validators.MovieValidator;
import ro.ubb.catalog.core.service.MovieService;
import ro.ubb.catalog.web.converter.MovieConverter;
import ro.ubb.catalog.web.dto.MovieDto;

import java.util.ArrayList;
import java.util.List;


@RestController
public class MovieController {
    public static final Logger log = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private MovieService movieService;

    @Autowired
    private MovieConverter movieConverter;

    @RequestMapping(value="/movies", method = RequestMethod.GET)
    List<MovieDto> getMovies(){
        log.trace("/movies GET - method entered:");
        return new ArrayList<>(movieConverter.convertModelsToDtos(movieService.getAllMovies()));
    }

    @RequestMapping(value = "/movies", method = RequestMethod.POST)
    MovieDto saveStudent(@RequestBody MovieDto movieDto) {
        log.trace("/movies POST - method entered: movieDto={}", movieDto);
        try {
            return movieConverter.convertModelToDto(movieService.saveMovie(
                    movieConverter.convertDtoToModel(movieDto)
            ));
        }
        catch (MovieRentalException ignored){
            return null;
        }
    }

    @RequestMapping(value = "/movies/{id}", method = RequestMethod.PUT)
    MovieDto updateMovie(@PathVariable Long id,
                               @RequestBody MovieDto movieDto) {
        log.trace("/movies PUT - method entered: id={} movieDto={}", id, movieDto);

        return movieConverter.convertModelToDto( movieService.updateMovie(id,
                movieConverter.convertDtoToModel(movieDto)));
    }

    @RequestMapping(value = "/movies/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteStudent(@PathVariable Long id){
        log.trace("/movies POST - method entered: id={}", id);

        movieService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @RequestMapping(value = "/movies/{name}", method = RequestMethod.GET)
//    MoviesDto filterCustomersByName(@PathVariable String name){
//        log.trace("/movies POST - method entered: name={}", name);
//
//        return new MoviesDto(movieConverter
//                .convertModelsToDtos(movieService.filterMoviesByName(name)));
//    }
}
