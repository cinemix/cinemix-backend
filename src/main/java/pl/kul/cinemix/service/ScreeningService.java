package pl.kul.cinemix.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kul.cinemix.dto.entity.ScreeningDto;
import pl.kul.cinemix.models.Hall;
import pl.kul.cinemix.models.Movie;
import pl.kul.cinemix.models.Screening;
import pl.kul.cinemix.repository.HallRepository;
import pl.kul.cinemix.repository.MovieRepository;
import pl.kul.cinemix.repository.ScreeningRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScreeningService {

    private final ScreeningRepository screeningRepository;
    private final MovieRepository movieRepository;
    private final HallRepository hallRepository;

    public List<Screening> getAllScreenings() {
        List<Screening> screenings = new ArrayList<>();
        screeningRepository.findAll().forEach(screenings::add);
        return screenings;
    }

    public ScreeningDto getScreening(Long id) {
        Optional<Screening> screening = screeningRepository.findById(id);
        ScreeningDto screeningDto =new ScreeningDto();
        screeningDto.setId(screening.get().getId());
        screeningDto.setDate(screening.get().getDate());
        screeningDto.setMovie(movieRepository.findById(screening.get().getMovie()).get());
        screeningDto.setHall(hallRepository.findById(screening.get().getHall()).get());
        return screeningDto;
    }

    public void addScreening(Screening screening) {
        screeningRepository.save(screening);
    }

    public void editScreening(Screening screening) {
        Screening screeningInDB = screeningRepository.findById(screening.getId()).get();
        screeningInDB.setMovie(screening.getMovie());
        screeningInDB.setHall(screening.getHall());
        screeningInDB.setDate(screening.getDate());
        screeningInDB.setTickets(Long.valueOf(10));
        screeningRepository.save(screeningInDB);
    }

    public void deleteScreening(Long id) {
        screeningRepository.deleteById(id);
    }

    public void ticketsReservation(Long ticketsAmount, Long seanseId){
       Optional<Screening> screening = screeningRepository.findById(seanseId);
       screening.get().setTickets(screening.get().getTickets()-ticketsAmount);
    }
    public void cancellTicketsReservation(Long ticketsAmount, Long seanseId){
       Optional<Screening> screening = screeningRepository.findById(seanseId);
       screening.get().setTickets(screening.get().getTickets()+ticketsAmount);
    }
}
