package pl.domain.coldroom.dto.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.domain.coldroom.models.Refrigerator;
import pl.domain.coldroom.models.Vaccine;

@Getter
@Setter
@NoArgsConstructor
public class ScreeningDto {
    private Long id;
    private String date;
    private Vaccine vaccine;
    private Refrigerator refrigerator;

    public ScreeningDto(Long id, String date, Vaccine vaccine, Refrigerator refrigerator) {
        this.id = id;
        this.date = date;
        this.vaccine = vaccine;
        this.refrigerator = refrigerator;
    }
}