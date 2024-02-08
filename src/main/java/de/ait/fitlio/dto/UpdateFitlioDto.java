package de.ait.fitlio.dto;

import de.ait.fitlio.model.Fitlio;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;

@Data
@Schema(name = "Update Fitlio")
public class UpdateFitlioDto {

//    private Long id;
    private String title;
    private String description;
    private int timeMinute;
    private int timeHour;
    private LocalDate date;
    private int calorie;
    private int distance;
    private Fitlio.FitType fitType;
}
