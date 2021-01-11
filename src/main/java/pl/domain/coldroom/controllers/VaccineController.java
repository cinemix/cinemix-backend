package pl.domain.coldroom.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.domain.coldroom.models.Vaccine;
import pl.domain.coldroom.service.VaccineService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {

    private final VaccineService vaccineService;

    @GetMapping("/all")
    public List<Vaccine> allMovies() {
        return vaccineService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Optional<Vaccine> getMovie(@PathVariable Long id) {
        return vaccineService.getVaccine(id);
    }

    @PostMapping("/add")
    // @PreAuthorize("hasRole('ADMIN')")
    public void addMovie(@RequestBody Vaccine vaccine) {
        vaccineService.addVaccine(vaccine);
    }

    @PutMapping("/edit")
    // @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    public void editMovie(@RequestBody Vaccine vaccine) {
        vaccineService.editVaccine(vaccine);
    }

    @DeleteMapping("/delete/{id}")
    //  @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    public void deleteMovie(@PathVariable Long id) {
        vaccineService.deleteVaccine(id);
    }
}
