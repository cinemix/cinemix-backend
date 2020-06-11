package pl.kul.cinemix.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kul.cinemix.dto.entity.ScreeningDto;
import pl.kul.cinemix.mappers.ScreeningMapper;
import pl.kul.cinemix.models.Screening;
import pl.kul.cinemix.service.ScreeningService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/screenings")
@RequiredArgsConstructor
public class ScreeningController {

    private final ScreeningService screeningService;
    private final ScreeningMapper screeningMapper;

    @GetMapping("/all")
    public List<Screening> allScreenings() {
        return screeningService.getAllScreenings();

    }

    @GetMapping("/{id}")
    public Optional<Screening> getScreening(@PathVariable Long id) {
        return screeningService.getScreening(id);
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    public void addScreening(@RequestBody Screening screening) {
        screeningService.addScreening(screening);
    }

    @PutMapping("/edit")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    public void editScreening(@RequestBody ScreeningDto screeningDto) {
        screeningService.editScreening(screeningMapper.mapToScreening(screeningDto));
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    public void deleteScreening(@PathVariable Long id) {
        screeningService.deleteScreening(id);
    }
}
