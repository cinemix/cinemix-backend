package pl.kul.cinemix.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
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
    public List<ScreeningDto> allScreenings(){
        return screeningService.getAllScreenings().stream()
                .map(screeningMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Optional<ScreeningDto> getScreening(@PathVariable Long id) {
        return screeningService.getScreening(id).map(screeningMapper::mapToDto);
    }

    @PostMapping("/add")
//    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    public void addScreening(@RequestBody Screening screening) {
        screeningService.addScreening(screening);
    }

    @PutMapping("/edit")
//    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    public void  editScreening(@RequestBody Screening screening){
        screeningService.editScreening(screening);
    }


    @DeleteMapping("/delete")
//    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    public void deleteScreening(@RequestBody Screening screening){
        screeningService.deleteScreening(screening.getId());
    }
}
