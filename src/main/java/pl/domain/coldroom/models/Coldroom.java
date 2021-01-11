package pl.domain.coldroom.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 *
 */
@Getter
@Setter
@Entity
@Table(name = "coldrooms")
@NoArgsConstructor
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String date;

    private Long vaccine;

    private Long refrigerator;

    public Screening(String date, Long vaccine, Long refrigerator) {
        this.date = date;
        this.vaccine = vaccine;
        this.refrigerator = refrigerator;
    }
}
