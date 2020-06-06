package pl.kul.cinemix.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "seats")
@NoArgsConstructor

public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Row row;

    private Boolean isAvailable;

    public Seat(@NotNull Row row, Boolean isAvailable) {
        this.row = row;
        this.isAvailable = isAvailable;
    }
}
