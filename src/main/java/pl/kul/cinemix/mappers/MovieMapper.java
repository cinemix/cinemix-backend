package pl.kul.cinemix.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.kul.cinemix.dto.entity.MovieDto;
import pl.kul.cinemix.dto.entity.ScreeningDto;
import pl.kul.cinemix.models.Movie;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    @Mapping(target = "screenings", ignore = true)
    Movie mapToMovie(MovieDto movieDto);

    @InheritInverseConfiguration(name = "mapToMovie")
    ScreeningDto mapToMovieDto(Movie movie);
}
