package ro.ubb.catalog.core.service;


import ro.ubb.catalog.core.model.entities.Movie;

import java.util.List;
import java.util.Set;

public interface MovieService {
    List<Movie> getAllMovies();

    Movie saveMovie(Movie movie);

    Movie updateMovie(Long id, Movie movie);

    void deleteById(Long id);

    public Set<Movie> filterMoviesByName(String name);
}
