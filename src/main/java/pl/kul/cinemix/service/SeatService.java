package pl.kul.cinemix.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kul.cinemix.dto.entity.MovieDto;
import pl.kul.cinemix.models.Seat;
import pl.kul.cinemix.repository.SeatRepository;
import pl.wavesoftware.eid.exceptions.EidRuntimeException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SeatService {
    private final SeatRepository seatRepository;



    public Optional<Seat> getSeat(Long id){
        return seatRepository.findById(id);
    }

    public void deleteSeat(Long id){
        seatRepository.deleteById(id);
    }

    public Collection<Seat> getAllSeatsById(Collection<Long> id){
        return (Collection<Seat>) seatRepository.findAllById(id);
    }

    public List<Seat> getAllSeats() {
        return (List<Seat>) seatRepository.findAll();
    }

    public void addEmptySeat(){
        seatRepository.save(new Seat());
    }

    public void setBusy(Long id){
        Seat seatToSet = seatRepository.findById(id).orElseThrow(() -> new EidRuntimeException("20200531:171144", "Nie ma takiego miejsca"));
        seatToSet.setIsAvailable(false);
        seatRepository.save(seatToSet);
    }

    public void setAvailable(Long id){
        Seat seatToSet = seatRepository.findById(id).orElseThrow(() -> new EidRuntimeException("20200531:171144", "Nie ma takiego miejsca"));
        seatToSet.setIsAvailable(true);
        seatRepository.save(seatToSet);
    }
}
