package pl.kul.cinemix.dto.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ScreeningDto {
    private final Long id;
    private final String date;
    private final Long movieId;
    private final Long hallId;
}
