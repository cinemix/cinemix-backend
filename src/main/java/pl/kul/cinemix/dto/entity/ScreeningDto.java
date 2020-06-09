package pl.kul.cinemix.dto.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ScreeningDto {
    private final Long id;
    private final String date;
    private final MovieDto movie;
    private final Long room;
}
