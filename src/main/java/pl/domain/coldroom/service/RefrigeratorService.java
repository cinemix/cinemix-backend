package pl.domain.coldroom.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.domain.coldroom.models.Refrigerator;
import pl.domain.coldroom.repository.HallRepository;
import pl.domain.coldroom.models.Screening;
import pl.domain.coldroom.repository.ScreeningRepository;
import pl.wavesoftware.eid.exceptions.EidRuntimeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HallService {

    private final HallRepository hallRepository;
    private final ScreeningRepository screeningRepository;
    private final ScreeningService screeningService;

    public void addHall(Refrigerator refrigerator) {
        hallRepository.save(refrigerator);
    }

    public Optional<Refrigerator> getHall(Long id) {
        return hallRepository.findById(id);
    }


    public void deleteHall(Long id) {
        List<Screening> screenings = new ArrayList<>();
        screeningRepository.findAll().forEach(screenings::add);


        for (Screening s : screenings) {
            if (s.getHall() == id) {
                screeningService.deleteScreening(s.getId());

            }
        }
        Refrigerator refrigerator =hallRepository.findById(id).orElseThrow(() -> new EidRuntimeException("20200531:171144", "There is no refrigerator specified by this id"));
        hallRepository.deleteById(refrigerator.getId());
    }

    public List<Refrigerator> getAllHalls() {
        List<Refrigerator> refrigerators = new ArrayList<>();
        hallRepository.findAll().forEach(refrigerators::add);
        return refrigerators;
    }

    public void editHall(Refrigerator refrigerator) {
        Refrigerator refrigeratorInDB = hallRepository.findById(refrigerator.getId())
                .orElseThrow(() -> new EidRuntimeException("20200531:171144", "Brak filmu w bazie do edycji"));
        refrigeratorInDB.setActive(refrigerator.isActive());
        refrigeratorInDB.setSeatsQuantity(refrigerator.getSeatsQuantity());
        hallRepository.save(refrigeratorInDB);
    }
}
