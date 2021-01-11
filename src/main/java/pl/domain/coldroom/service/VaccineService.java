package pl.domain.coldroom.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.domain.coldroom.models.Vaccine;
import pl.domain.coldroom.repository.MovieRepository;
import pl.domain.coldroom.repository.ReservationRepository;
import pl.domain.coldroom.models.Screening;
import pl.domain.coldroom.repository.ScreeningRepository;
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

    public List<Vaccine> getAllMovies() {
        List<Vaccine> vaccines = new ArrayList<>();
        movieRepository.findAll().forEach(vaccines::add);

        return vaccines;
    }

    public Optional<Vaccine> getMovie(Long id) {

        return movieRepository.findById(id);
    }

    public void addMovie(Vaccine vaccine) {
        movieRepository.save(vaccine);
    }

    public void editMovie(Vaccine vaccine) {
        Vaccine vaccineInDB = movieRepository.findById(vaccine.getId())
                .orElseThrow(() -> new EidRuntimeException("20200531:171144", "Brak filmu w bazie do edycji"));
        vaccineInDB.setTitle(vaccine.getTitle());
        vaccineInDB.setAuthor(vaccine.getAuthor());
        vaccineInDB.setDescription(vaccine.getDescription());
        vaccineInDB.setYear(vaccine.getYear());
        vaccineInDB.setCountry(vaccine.getCountry());
        vaccineInDB.setDuration(vaccine.getDuration());
        movieRepository.save(vaccineInDB);
    }

    public void deleteMovie(Long id) {

        List<Screening> screenings = new ArrayList<>();
        screeningRepository.findAll().forEach(screenings::add);

        for (Screening s : screenings) {
            if (s.getMovie() == id) {
                screeningService.deleteScreening(s.getId());
            }
        }

        Vaccine vaccine = movieRepository.findById(id).orElseThrow(() -> new EidRuntimeException("20200531:171144", "There is no vaccine specified by this id"));
        movieRepository.deleteById(vaccine.getId());
    }
}
