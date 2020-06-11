package pl.kul.cinemix.models;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Set;
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

    public Hall( Long seatsQuantity, boolean isActive) {
        this.seatsQuantity=seatsQuantity;
        this.isActive=isActive;
    }
}
