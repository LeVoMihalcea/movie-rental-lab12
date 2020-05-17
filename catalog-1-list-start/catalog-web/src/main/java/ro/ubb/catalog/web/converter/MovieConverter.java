package ro.ubb.catalog.web.converter;

import org.springframework.stereotype.Component;
import ro.ubb.catalog.core.model.entities.Movie;
import ro.ubb.catalog.web.dto.MovieDto;

@Component
public class MovieConverter extends BaseConverter<Movie, MovieDto> {
    @Override
    public Movie convertDtoToModel(MovieDto dto) {
        Movie movie = Movie.builder()
                .title(dto.getTitle())
                .yearOfRelease(dto.getYearOfRelease())
                .build();
        movie.setId(dto.getId());
        return movie;
    }

    @Override
    public MovieDto convertModelToDto(Movie movie) {
        MovieDto dto = MovieDto.builder()
                .title(movie.getTitle())
                .yearOfRelease(movie.getYearOfRelease())
                .build();
        dto.setId(movie.getId());
        return dto;
    }
}
