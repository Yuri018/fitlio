package de.ait.fitlio.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateFitlioDto {
    public enum FitType {
        CARDIO, CALORIE, POWER, GAME, GENERAL
    }

//    private Long id;
    private String title;
    private String description;
    private int timeMinute;
    private int timeHour;
    private LocalDate date;
    private int calorie;
    private int distance;
    private FitType fitType;
}
