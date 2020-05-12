package pl.kul.cinemix.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import pl.kul.cinemix.models.Movie;
@Qualifier("movies")
public interface MovieRepository extends CrudRepository<Movie, Long> {
}
