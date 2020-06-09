package pl.kul.cinemix.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kul.cinemix.models.Hall;
import pl.kul.cinemix.repository.HallRepository;

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

    public void addEmptyHall(){
        hallRepository.save(new Hall());
    }
}
