package pl.kul.cinemix.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kul.cinemix.models.Screening;
import pl.kul.cinemix.repository.ScreeningRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScreeningService {

    private final ScreeningRepository screeningRepository;

    public List<Screening> getAllScreenings() {
        List<Screening> screenings = new ArrayList<>();
        screeningRepository.findAll().forEach(screenings::add);
        return screenings;
    }

    public Optional<Screening> getScreening(Long id) {
        return screeningRepository.findById(id);
    }

    public void addScreening(Screening screening) {
        screeningRepository.save(screening);
    }

    public void editScreening(Screening screening){
        Screening screeningInDB = screeningRepository.findById(screening.getId()).get();
        screeningInDB.setMovie(screening.getMovie());
        screeningInDB.setRoom(screening.getRoom());
        screeningInDB.setDate(screening.getDate());
        screeningRepository.save(screeningInDB);

    }

    public void deleteScreening(Long id) {
        screeningRepository.deleteById(id);
    }
}
