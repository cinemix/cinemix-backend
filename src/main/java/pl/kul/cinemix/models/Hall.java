package pl.kul.cinemix.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "halls")
@NoArgsConstructor
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long seatsQuantity;
    private boolean isActive;

    public Hall(Long seatsQuantity, boolean isActive) {
        this.seatsQuantity = seatsQuantity;
        this.isActive = isActive;
    }
}
