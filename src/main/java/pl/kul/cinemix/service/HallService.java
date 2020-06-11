package pl.kul.cinemix.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kul.cinemix.models.Hall;
import pl.kul.cinemix.models.Movie;
import pl.kul.cinemix.repository.HallRepository;
import pl.wavesoftware.eid.exceptions.EidRuntimeException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HallService{

    private final HallRepository hallRepository;

    public void addHall(Hall hall){
        hallRepository.save(hall);
    }

    public Optional<Hall> getHall(Long id){
        return hallRepository.findById(id);
    }

    public void deleteHall(Long id ){
        hallRepository.deleteById(id);
    }

    public List<Hall> getAllHalls() {
        List<Hall> halls = new ArrayList<>();
        hallRepository.findAll().forEach(halls::add);
        return halls;
    }

    public void editHall(Hall hall) {
        Hall hallInDB = hallRepository.findById(hall.getId())
                .orElseThrow(() -> new EidRuntimeException("20200531:171144", "Brak filmu w bazie do edycji"));
        hallInDB.setActive(hall.isActive());
        hallInDB.setSeatsQuantity(hall.getSeatsQuantity());
        hallRepository.save(hallInDB);
    }
}
