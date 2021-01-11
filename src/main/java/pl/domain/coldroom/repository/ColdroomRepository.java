package pl.domain.coldroom.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.domain.coldroom.models.Screening;

@Qualifier("screenings")
@Repository
public interface ScreeningRepository extends CrudRepository<Screening, Long> {
}
