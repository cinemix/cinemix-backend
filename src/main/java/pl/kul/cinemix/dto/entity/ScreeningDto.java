package pl.kul.cinemix.dto.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.kul.cinemix.models.Hall;
import pl.kul.cinemix.models.Movie;

@Getter
@Setter
@NoArgsConstructor
public class ScreeningDto {
    private  Long id;
    private  String date;
    private  Movie movie;
    private  Hall hall;
    private Long tickets;


public ScreeningDto(Long id, String date, Movie movie, Hall hall, Long tickets){
    this.id = id;
    this.date = date;
    this.movie = movie;
    this.hall = hall;
    this.tickets = tickets;
}
}