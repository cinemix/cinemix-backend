package pl.domain.coldroom.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.domain.coldroom.models.Refrigerator;
import pl.domain.coldroom.service.RefrigeratorService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/refrigerators")
@RequiredArgsConstructor
public class HallController {

    private final RefrigeratorService refrigeratorService;

    @GetMapping("/all")
    public List<Refrigerator> allHalls() {
        return refrigeratorService.getAllRefrigerators();
    }

    @GetMapping("/{id}")
    public Optional<Refrigerator> getHall(@PathVariable Long id) {
        return refrigeratorService.getRefrigerator(id);
    }

    @PostMapping("/add")
    public void addHall(@RequestBody Refrigerator refrigerator) {
        refrigeratorService.addRefrigerator(refrigerator);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteHall(@PathVariable Long id) {
        refrigeratorService.deleteRefrigerator(id);
    }

    @PutMapping("/edit")
    public void editHall(@RequestBody Refrigerator refrigerator) {
        refrigeratorService.editRefrigerator(refrigerator);
    }

}


