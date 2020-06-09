package pl.kul.cinemix.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kul.cinemix.models.Hall;

@Qualifier("halls")
@Repository
public interface HallRepository extends CrudRepository <Hall, Long> {
}
