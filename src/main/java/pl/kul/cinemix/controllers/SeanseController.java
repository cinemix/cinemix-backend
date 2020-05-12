package pl.kul.cinemix.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.kul.cinemix.models.Seanse;
import pl.kul.cinemix.service.SeanseService;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/seanses")
@RequiredArgsConstructor
public class SeanseController {

    private final SeanseService seanseService;

    @GetMapping("/all")
    public List<Seanse> allSeanses(){
        return seanseService.getAllSeanses();
    }

    @GetMapping("/{id}")
    public Optional<Seanse> getSeanse(@PathVariable Long id) {
        return seanseService.getSeanse(id);
    }

    @PostMapping("/add")
   // @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    public void addSeanse(@RequestBody Seanse seanse) {
        seanseService.addSeanse(seanse);
    }

    @PutMapping("/edit")
    //@PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    public void  editMovie(@RequestBody Seanse seanse){
        seanseService.editSeanse(seanse);
    }


    @DeleteMapping("/delete")
    //@PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    public void deleteSeanse(@RequestBody Seanse seanse){
        seanseService.deleteSeanse(seanse.getId());
    }
}
