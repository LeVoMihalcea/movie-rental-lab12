package ro.ubb.catalog.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.ubb.catalog.core.model.entities.Movie;
import ro.ubb.catalog.core.model.validators.MovieValidator;
import ro.ubb.catalog.core.repository.MovieRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MovieServiceImpl implements MovieService {
    public static final Logger log = LoggerFactory.getLogger(MovieServiceImpl.class);
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieValidator movieValidator;

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie saveMovie(Movie movie) {
        log.trace("saveMovie - method entered: movie={}", movie);
        this.movieValidator.validate(movie);
        log.trace("saveMovie - movie validated: movie={}", movie);
        log.trace("saveMovie - saving movie - finishing method after repository save: movie={}", movie);
        return movieRepository.save(movie);
    }

    @Override
    @Transactional
    public Movie updateMovie(Long id, Movie movie) {
        movie.setId(id);
        this.movieValidator.validate(movie);
        log.trace("updateMovie - method entered: movie={}", movie);
        movieRepository.findById(movie.getId())
                .ifPresent(s -> {
                    s.setTitle(movie.getTitle());
                    s.setYearOfRelease(movie.getYearOfRelease());
                    log.debug("updateMovie - updated: s={}", s);
                });
        log.trace("updateMovie - method finished");
        return movie;
    }

    @Override
    public Set<Movie> filterMoviesByName(String name) {
        log.trace("filterMoviesByName - method entered: name={}", name);
        Iterable<Movie> movies = movieRepository.findAll();
        Set<Movie> filteredMovies = new HashSet<>();
        movies.forEach(filteredMovies::add);
        filteredMovies.removeIf(movie -> !movie.getTitle().contains(name));
        log.trace("filterMoviesByName - method entered: name={}", name);
        
        return filteredMovies;
    }


    @Override
    public void deleteById(Long id) {
        log.trace("deleteById - method entered: id={}", id);
        movieRepository.findById(id).ifPresent(
                x -> {
                    movieRepository.deleteById(id);
                    log.trace("deleteById - deleted Movie: id={}", id);
                }
        );
        log.trace("deleteById - method finished: id={}", id);
    }
}
