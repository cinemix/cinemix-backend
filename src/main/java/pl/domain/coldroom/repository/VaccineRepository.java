package pl.domain.coldroom.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import pl.domain.coldroom.models.Vaccine;

@Qualifier("movies")
public interface MovieRepository extends CrudRepository<Vaccine, Long> {
}
