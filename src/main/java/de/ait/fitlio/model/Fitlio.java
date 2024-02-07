package de.ait.fitlio.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
@Entity
@Table(name = "fitlio")
public class Fitlio {

    public enum FitType {
        CARDIO, CALORIE, POWER, GAME, GENERAL, STAMINA, OTHER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 200)
    private String title;
    @Column(nullable = true, length = 1000)
    private String description;
    @Column
    private int timeMinute;
    @Column
    private int timeHour;
    @Column(nullable = false)
    private LocalDate date;
    @Column
    private int calorie;
    @Column
    private int distance;
    @Enumerated(value = EnumType.STRING)
    private FitType fitType;
}
