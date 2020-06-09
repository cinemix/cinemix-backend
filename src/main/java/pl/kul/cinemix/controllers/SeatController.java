package pl.kul.cinemix.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.kul.cinemix.models.Seat;
import pl.kul.cinemix.service.SeatService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/seats")
@RequiredArgsConstructor
public class SeatController{

    private final SeatService seatService;

    @GetMapping("/{id}")
    public Optional<Seat> getSeat(@PathVariable Long id){
        return seatService.getSeat(id);
    }



    @DeleteMapping("/delete/{id}")
    public void deleteSeat(@PathVariable Long id){
        seatService.deleteSeat(id);
    }

    @GetMapping("/all")
    public List<Seat> getAllSeats(){
        return seatService.getAllSeats();
    }

    @PostMapping("/add")
    public void addEmptySeat(){
        seatService.addEmptySeat();
    }

    @PutMapping("/set/busy/{id}")
    public void setBusy(@PathVariable Long id){
        seatService.setBusy(id);
    }

    @PutMapping("/set/available/{id}")
    public void setAvailable(@PathVariable Long id){
        seatService.setAvailable(id);
    }

}
