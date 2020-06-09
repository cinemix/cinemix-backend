package pl.kul.cinemix.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.kul.cinemix.models.Row;
import pl.kul.cinemix.models.Seat;
import pl.kul.cinemix.service.SeatService;

import java.util.Collection;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/seats")
@RequiredArgsConstructor
public class SeatController{

    SeatService SeatService;

    @GetMapping("/{id}")
    public Optional<Seat> getSeat(@PathVariable Long id){
        return SeatService.getSeat(id);
    }

    @PostMapping("/add")
    public void addHall(@RequestBody Seat seat){
        SeatService.addSeat(seat);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteHall(@PathVariable Long id){
        SeatService.deleteSeat(id);
    }

    @GetMapping("/all")
    public void getAllHalls(){
        SeatService.getAllSeats();
    }
}
