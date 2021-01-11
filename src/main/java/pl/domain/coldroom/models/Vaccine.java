package pl.domain.coldroom.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "movies", uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 128)
    private String title;

    @NotBlank
    @Size(max = 64)
    private String author;

    private String description;

    private String year;

    private String country;
    @NotNull
    private Long duration;

    public Movie(
            @NotBlank @Size(max = 64) String author,
            @NotBlank @Size(max = 128) String title,
            String description,
            String year,
            String country,
            @NotNull
                    Long duration) {

        this.title = title;
        this.author = author;
        this.description = description;
        this.year = year;
        this.country = country;
        this.duration = duration;

    }
}
