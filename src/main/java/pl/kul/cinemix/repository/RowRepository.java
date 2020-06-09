package pl.kul.cinemix.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kul.cinemix.models.Row;

@Qualifier("rows")
@Repository
public interface RowRepository extends CrudRepository<Row, Long> {
}

