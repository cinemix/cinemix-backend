package pl.kul.cinemix.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kul.cinemix.models.Reservation;

@Qualifier("reservations")
@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
}
