package pl.kul.cinemix.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.kul.cinemix.models.Hall;
import pl.kul.cinemix.service.HallService;

import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/halls")
@RequiredArgsConstructor
public class HallController {

    HallService hallService;

    @GetMapping("/{id}")
    public Optional<Hall> getHall(@PathVariable Long id){
        return hallService.getHall(id);
    }

    @PostMapping("/add")
    public void addHall(@RequestBody Hall hall){
        hallService.addHall(hall);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteHall(@PathVariable Long id){
        hallService.deleteHall(id);
    }
}
