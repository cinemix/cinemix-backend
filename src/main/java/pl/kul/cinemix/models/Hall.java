package pl.kul.cinemix.models;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Set;
@Getter
@Setter
@Entity
@Table(name = "halls", uniqueConstraints = {@UniqueConstraint(columnNames = "hallindex")})
@NoArgsConstructor
public class Hall {
    private Long id;
    private Long hallIndex;
    private Set<Long> rows;
    private Set<Screening> screenings;

    public Hall(Set<Screening> screenings, Set<Long> rows) {
        this.screenings = screenings;
        this.rows = rows;
    }

}
