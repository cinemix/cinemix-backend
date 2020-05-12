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

    @NotNull
    @Column(name = "movie_id")
    private Long movie;

    @NotBlank
    private String date;

    @NotNull
    private Long room;

    public Screening(@NotNull Long movie, @NotBlank  String date, @NotBlank Long room) {
        this.movie = movie;
        this.date = date;
        this.room = room;
    }
}
