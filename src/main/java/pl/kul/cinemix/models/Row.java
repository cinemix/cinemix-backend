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
@Table(name = "rows")
@NoArgsConstructor
public class Row {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Hall hall;

    @OneToMany(mappedBy="row")
    private Set<Seat> seats;

    public Row(Hall hall) {
        this.hall = hall;
    }
}
