package pl.kul.cinemix.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kul.cinemix.models.Seat;

@Qualifier("seats")
@Repository
public interface SeatRepository extends CrudRepository<Seat, Long> {
}
