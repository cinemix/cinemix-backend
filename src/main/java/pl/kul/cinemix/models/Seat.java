package pl.kul.cinemix.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "seats", uniqueConstraints = {@UniqueConstraint(columnNames = "seatindex")})
@NoArgsConstructor

public class Seat {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Long seatIndex;

    private Long rowId;
    private boolean isAvailable;

    public Seat(@NotNull Long seatIndex, @NotNull Long rowId) {
        this.seatIndex = seatIndex;
        this.rowId = rowId;
        isAvailable=true;
    }

    public Seat(@NotNull Long seatIndex, @NotNull Long rowId, boolean isAvailable) {
        this.seatIndex = seatIndex;
        this.rowId = rowId;
        this.isAvailable = isAvailable;
    }
}
