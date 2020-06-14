package pl.kul.cinemix.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.kul.cinemix.models.Reservation;
import pl.kul.cinemix.service.ReservationService;

import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> allReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable Long id) {
        return reservationService.getReservation(id);
    }

    @GetMapping("/username/{username}")
    public List<Reservation> getReservation(@PathVariable String username) {
        return reservationService.getReservationsByUsername(username);
    }

    @PutMapping("/reservation")
    public boolean ticketsReservation(@RequestBody Reservation reservation) {
        return reservationService.checkReservation(reservation);
    }

    @PutMapping("/cancelreservation/{reservationId}")
    public boolean cancelTicketsReservation(@PathVariable Long reservationId) {
        return reservationService.checkCancelReservation(reservationId);
    }
}
