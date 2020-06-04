package pl.kul.cinemix.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kul.cinemix.dto.entity.MovieDto;
import pl.kul.cinemix.mappers.MovieMapper;
import pl.kul.cinemix.models.Movie;
import pl.kul.cinemix.repository.MovieRepository;
import pl.wavesoftware.eid.exceptions.EidRuntimeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    public List<MovieDto> getAllMovies() {
        List<MovieDto> movies = new ArrayList<>();
        movieRepository.findAll().forEach(movie -> movies.add(movieMapper.mapToMovieDto(movie)));
        return movies;
    }

    public Optional<MovieDto> getMovie(Long id) {

        return movieRepository.findById(id).map(movieMapper::mapToMovieDto);
    }

    public void addMovie(MovieDto movieDto) {
        movieRepository.save(movieMapper.mapToMovie(movieDto));
    }

    public void editMovie(MovieDto movieDto) {
        Movie movieInDB = movieRepository.findById(movieDto.getId())
                .orElseThrow(() -> new EidRuntimeException("20200531:171144", "Brak filmu w bazie do edycji"));
        movieInDB.setTitle(movieDto.getTitle());
        movieInDB.setAuthor(movieDto.getAuthor());
        movieRepository.save(movieInDB);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
