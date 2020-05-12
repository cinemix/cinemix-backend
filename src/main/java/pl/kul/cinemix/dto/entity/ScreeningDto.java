package pl.kul.cinemix.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pl.kul.cinemix.models.Movie;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ScreeningDto {
    Long id;
    Movie movie;
    String date;
    Long room;
}
