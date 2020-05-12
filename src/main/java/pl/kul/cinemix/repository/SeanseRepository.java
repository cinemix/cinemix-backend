package pl.kul.cinemix.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kul.cinemix.models.Seanse;

@Qualifier("seanses")
@Repository
public interface SeanseRepository extends CrudRepository<Seanse, Long> {
}
