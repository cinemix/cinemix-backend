package pl.kul.cinemix.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kul.cinemix.models.Screening;

@Qualifier("screenings")
@Repository
public interface ScreeningRepository extends CrudRepository<Screening, Long> {
}
