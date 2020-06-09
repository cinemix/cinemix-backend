package pl.kul.cinemix.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kul.cinemix.models.Seat;
import pl.kul.cinemix.repository.SeatRepository;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SeatService {
    private final SeatRepository seatRepository;

    public void addSeat(Seat seat){
        seatRepository.save(seat);

    }

    public Optional<Seat> getSeat(Long id){
        return seatRepository.findById(id);
    }

    public void deleteSeat(Long id){
        seatRepository.deleteById(id);
    }

    public Collection<Seat> getAllSeatsById(Collection<Long> id){
        return (Collection<Seat>) seatRepository.findAllById(id);
    }

    public void getAllSeats() {
        seatRepository.findAll();
    }
}
