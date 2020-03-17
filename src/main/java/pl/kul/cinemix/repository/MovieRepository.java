package pl.kul.cinemix.repository;

import org.springframework.data.repository.CrudRepository;
import pl.kul.cinemix.models.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long> {
}
