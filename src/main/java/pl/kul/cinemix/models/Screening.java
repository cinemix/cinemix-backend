package pl.kul.cinemix.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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

    @ManyToOne
    private Movie movie;

    @NotBlank
    private String date;

    @NotNull
    private Long room;

    public Screening(@NotNull Movie movie, @NotBlank  String date, @NotBlank Long room) {
        this.movie = movie;
        this.date = date;
        this.room = room;
    }
}
