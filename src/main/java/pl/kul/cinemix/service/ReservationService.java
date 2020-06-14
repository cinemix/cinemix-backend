package pl.kul.cinemix.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kul.cinemix.models.Hall;
import pl.kul.cinemix.models.Reservation;
import pl.kul.cinemix.models.Screening;
import pl.kul.cinemix.repository.HallRepository;
import pl.kul.cinemix.repository.ReservationRepository;
import pl.kul.cinemix.repository.ScreeningRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final ScreeningRepository screeningRepository;
    private final HallRepository hallRepository;

    public List<Reservation> getAllReservations() {
        List<Reservation> reservations = new ArrayList<>();
        reservationRepository.findAll().forEach(reservations::add);
        return reservations;
    }

    public List<Reservation> getReservationsByUsername(String username) {
        List<Reservation> reservations = getAllReservations();
        List<Reservation> reservationsToReturn = new ArrayList<>();
        for (Reservation r : reservations) {
            if (r.getUsername().equals(username)) {
                reservationsToReturn.add(r);
            }
        }
        return reservationsToReturn;
    }

    public Reservation getReservation(Long id) {
        return reservationRepository.findById(id).get();
    }


    public void ticketsReservation(Reservation reservation) {
        Screening screening = screeningRepository.findById(reservation.getScreening()).get();
        screening.setTickets(screening.getTickets() - reservation.getTickets());
        Reservation reservationDto = new Reservation(reservation.getScreening(), reservation.getUsername(), reservation.getTickets());
        reservationRepository.save(reservationDto);
        screeningRepository.save(screening);
    }

    public boolean checkReservation(Reservation reservation) {
        Optional<Screening> screening = screeningRepository.findById(reservation.getScreening());
        if (screening.get().getTickets() < reservation.getTickets())
            return false;
        else {
            ticketsReservation(reservation);
            return true;
        }
    }

    public void cancelTicketsReservation(Reservation reservation) {

        Screening screening = screeningRepository.findById(reservation.getId()).get();
        screening.setTickets(screening.getTickets() + reservation.getTickets());
        screeningRepository.save(screening);
        reservationRepository.deleteById(reservation.getId());
    }

    public boolean checkCancelReservation(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId).get();
        Screening screening = screeningRepository.findById(reservation.getScreening()).get();
        Hall hall = hallRepository.findById(screening.getHall()).get();
        if ((screening.getTickets() + reservation.getTickets()) > hall.getSeatsQuantity())
            return false;
        else {
            cancelTicketsReservation(reservation);
            return true;
        }
    }
}
