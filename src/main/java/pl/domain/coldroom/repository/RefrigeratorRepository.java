package pl.domain.coldroom.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.domain.coldroom.models.Refrigerator;

@Qualifier("halls")
@Repository
public interface HallRepository extends CrudRepository <Refrigerator, Long> {
}
