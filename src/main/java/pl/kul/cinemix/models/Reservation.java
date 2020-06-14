package pl.kul.cinemix.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@Entity
@Table(name = "reservations", uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id=Long.valueOf(1);

    @NotNull
    private Long screening;
    @NotNull
    private Long tickets;
    @NotNull
    private String username;

    public Reservation(Long screening, String username, Long tickets) {
        this.screening = screening;
        this.username = username;
        this.tickets = tickets;
    }
}


