package pl.kul.cinemix.dto.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MovieDto {
    private final Long id;
    private final String title;
    private final String author;
    private final String description;
    private final String year;
    private final String country;
    private final Long duration;
}
