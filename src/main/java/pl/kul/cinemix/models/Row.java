package pl.kul.cinemix.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "rows", uniqueConstraints = {@UniqueConstraint(columnNames = "rowindex")})
@NoArgsConstructor
public class Row {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Row(Long rowIndex, Long hallId, Set<Long> seats) {
        this.rowIndex = rowIndex;
        this.hallId = hallId;
        seats = seats;
    }

    private Long rowIndex;

    private Long hallId;

    private Set<Long> Seats;
}
