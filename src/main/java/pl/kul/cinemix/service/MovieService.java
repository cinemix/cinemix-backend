package pl.kul.cinemix.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kul.cinemix.models.Movie;
import pl.kul.cinemix.models.Screening;
import pl.kul.cinemix.repository.MovieRepository;
import pl.kul.cinemix.repository.ReservationRepository;
import pl.kul.cinemix.repository.ScreeningRepository;
import pl.wavesoftware.eid.exceptions.EidRuntimeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final ScreeningRepository screeningRepository;
    private final ReservationRepository reservationRepository;
    private final ScreeningService screeningService;

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
        Movie movieInDB = movieRepository.findById(movie.getId())
                .orElseThrow(() -> new EidRuntimeException("20200531:171144", "Brak filmu w bazie do edycji"));
        movieInDB.setTitle(movie.getTitle());
        movieInDB.setAuthor(movie.getAuthor());
        movieInDB.setDescription(movie.getDescription());
        movieInDB.setYear(movie.getYear());
        movieInDB.setCountry(movie.getCountry());
        movieInDB.setDuration(movie.getDuration());
        movieRepository.save(movieInDB);
    }

    public void deleteMovie(Long id) {

        List<Screening> screenings = new ArrayList<>();
        screeningRepository.findAll().forEach(screenings::add);

        for (Screening s : screenings) {
            if (s.getMovie() == id) {
                screeningService.deleteScreening(s.getId());
            }
        }

        Movie movie = movieRepository.findById(id).orElseThrow(() -> new EidRuntimeException("20200531:171144", "There is no movie specified by this id"));
        movieRepository.deleteById(movie.getId());
    }
}
