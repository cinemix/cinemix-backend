package pl.kul.cinemix.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


/**
 *
 */
@Getter
@Setter
@Entity
@Table(name = "screenings")
@NoArgsConstructor
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String date;


    private Long movie;

    private Long hall;

    private Long tickets;

    public Screening(String date, Long movie, Long hall, Long tickets) {
        this.date = date;
        this.movie = movie;
        this.hall = hall;
        this.tickets = tickets;
    }

    public Long setTicketsAmountByHall(Hall hall) {
        return hall.getSeatsQuantity();
    }
}
