package pl.kul.cinemix.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kul.cinemix.models.Movie;
import pl.kul.cinemix.repository.MovieRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        movieRepository.findAll().forEach(movies::add);
        return movies;
    }

    public Optional<Movie> getMovie(Long id) {
        return movieRepository.findById(id);
    }

    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public void editMovie(Movie movie) {
        Movie movieInDB = movieRepository.findById(movie.getId()).get();
        movieInDB.setTitle(movie.getTitle());
        movieInDB.setAuthor(movie.getAuthor());
        movieInDB.setDescription(movie.getDescription());
        movieInDB.setYear(movie.getYear());
        movieInDB.setCountry(movie.getCountry());
        movieInDB.setDuration(movie.getDuration());
        movieRepository.save(movieInDB);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
