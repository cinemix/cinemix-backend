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
}
