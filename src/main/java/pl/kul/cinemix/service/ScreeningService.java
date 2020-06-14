package pl.kul.cinemix.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kul.cinemix.dto.entity.ScreeningDto;
import pl.kul.cinemix.models.Hall;
import pl.kul.cinemix.models.Reservation;
import pl.kul.cinemix.models.Screening;
import pl.kul.cinemix.repository.HallRepository;
import pl.kul.cinemix.repository.MovieRepository;
import pl.kul.cinemix.repository.ReservationRepository;
import pl.kul.cinemix.repository.ScreeningRepository;
import pl.wavesoftware.eid.exceptions.EidRuntimeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScreeningService {

    private final ScreeningRepository screeningRepository;
    private final MovieRepository movieRepository;
    private final HallRepository hallRepository;
    private final ReservationRepository reservationRepository;

    public List<ScreeningDto> getAllScreenings() {
        List<Screening> screenings = new ArrayList<>();
        List<ScreeningDto> screeningsDto = new ArrayList<>();
        screeningRepository.findAll().forEach(screenings::add);

        for (Screening s : screenings) {
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
        ScreeningDto screeningDto = new ScreeningDto();
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
        screeningRepository.save(screeningInDB);
    }

    public void deleteScreening(Long id) {

        List<Reservation> reservations = new ArrayList<>();
        reservationRepository.findAll().forEach(reservations::add);
        for (Reservation r : reservations) {
            if (r.getScreening() == id)
                reservationRepository.deleteById(r.getId());
        }
       Screening screening=screeningRepository.findById(id).orElseThrow(() -> new EidRuntimeException("20200531:171144", "There is no screening specified by this id"));
        screeningRepository.deleteById(id);
    }


}
