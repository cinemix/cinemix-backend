package pl.kul.cinemix.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kul.cinemix.models.Seanse;
import pl.kul.cinemix.repository.SeanseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SeanseService {

    private final SeanseRepository seanseRepository;

    public List<Seanse> getAllSeanses() {
        List<Seanse> seanses = new ArrayList<>();
        seanseRepository.findAll().forEach(seanses::add);
        return seanses;
    }

    public Optional<Seanse> getSeanse(Long id) {
        return seanseRepository.findById(id);
    }

    public void addSeanse(Seanse seanse) {
        seanseRepository.save(seanse);
    }

    public void editSeanse(Seanse seanse){
        Seanse seanseInDB = seanseRepository.findById(seanse.getId()).get();
        seanseInDB.setMovie(seanse.getMovie());
        seanseInDB.setRoom(seanse.getRoom());
        seanseInDB.setDate(seanse.getDate());
        seanseRepository.save(seanseInDB);

    }

    public void deleteSeanse(Long id) {
        seanseRepository.deleteById(id);
    }
}
