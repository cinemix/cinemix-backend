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
@Table(name = "seanses", uniqueConstraints = {@UniqueConstraint(columnNames = "movie")})
@NoArgsConstructor
public class Seanse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String movie;

    @NotBlank
    private String date;

    @NotNull
    private int room;

    public Long getId() {
        return id;
    }


    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public Seanse(@NotBlank String movie, @NotBlank  String date, @NotBlank int room) {
        this.movie = movie;
        this.date = date;
        this.room = room;
    }
}
