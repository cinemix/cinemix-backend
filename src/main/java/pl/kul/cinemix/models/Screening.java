package pl.kul.cinemix.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


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

    @ManyToOne
    private Movie movie;

    //@NotNull
    //@ManyToOne
    //private Hall hall;, @NotBlank Hall hall        this.hall = hall;

    public Screening(@NotNull Movie movie, @NotBlank  String date) {
        this.date = date;
        this.movie = movie;

    }
}
