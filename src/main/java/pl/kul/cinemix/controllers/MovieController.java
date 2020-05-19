package pl.kul.cinemix.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.kul.cinemix.models.Movie;
import pl.kul.cinemix.service.MovieService;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/all")
    public List<Movie> allMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Optional<Movie> getMovie(@PathVariable Long id) {
        return movieService.getMovie(id);
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public void addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
    }

    @PutMapping("/edit")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    public void  editMovie(@RequestBody Movie movie){
        movieService.editMovie(movie);
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    public void deleteMovie(@RequestBody Movie movie) {
        movieService.deleteMovie(movie.getId());
    }
}
