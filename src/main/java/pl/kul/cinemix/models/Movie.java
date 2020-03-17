package pl.kul.cinemix.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "movies", uniqueConstraints = {@UniqueConstraint(columnNames = "title")})
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

    public Movie(@NotBlank @Size(max = 128) String title, @NotBlank @Size(max = 64) String author) {
        this.title = title;
        this.author = author;
    }
}
