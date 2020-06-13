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

    public List<ScreeningDto> getAllScreenings() {
        List<Screening> screenings = new ArrayList<>();
        List<ScreeningDto> screeningsDto = new ArrayList<>();
        screeningRepository.findAll().forEach(screenings::add);
        for(Screening s: screenings){
            screeningsDto.add(
                    new ScreeningDto(
                            s.getId(),
                            s.getDate(),
                            movieRepository.findById(s.getMovie()).get(),
                            hallRepository.findById(s.getHall()).get(),
                            s.getTickets()));
        }
        return screeningsDto;
    }

    public ScreeningDto getScreening(Long id) {
        Optional<Screening> screening = screeningRepository.findById(id);
        ScreeningDto screeningDto =new ScreeningDto();
        screeningDto.setId(screening.get().getId());
        screeningDto.setDate(screening.get().getDate());
        screeningDto.setMovie(movieRepository.findById(screening.get().getMovie()).get());
        screeningDto.setHall(hallRepository.findById(screening.get().getHall()).get());
        screeningDto.setTickets(screening.get().getTickets());
        return screeningDto;
    }

    public void addScreening(Screening screening) {
        screening.setTickets(hallRepository.findById(screening.getHall()).get().getSeatsQuantity());
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

    public void ticketsReservation(Long ticketsAmount, Screening screening){

       screening.setTickets(screening.getTickets()-ticketsAmount);
       screeningRepository.save(screening);
    }

    public boolean checkReservation(Long ticketsAmount, Long screeningId){
        Optional<Screening> screening = screeningRepository.findById(screeningId);
        if(screening.get().getTickets()<ticketsAmount)
            return false;
        else{
            ticketsReservation(ticketsAmount,screening.get());
            return true;
        }
    }

    public void cancelTicketsReservation(Long ticketsAmount, Screening screening){

       screening.setTickets(screening.getTickets()+ticketsAmount);
        screeningRepository.save(screening);
    }

    public boolean checkCancelReservation(Long ticketsAmount, Long screeningId){
        Optional<Screening> screening = screeningRepository.findById(screeningId);
        Hall hall = hallRepository.findById(screening.get().getHall()).get();
        if((screening.get().getTickets()+ticketsAmount)> hall.getSeatsQuantity())
            return false;
        else{
            cancelTicketsReservation(ticketsAmount,screening.get());
            return true;
        }
    }
}
