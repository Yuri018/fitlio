package de.ait.fitlio.dto;

import de.ait.fitlio.model.Fitlio;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Schema(name = "New User Dto")
public class NewFitlioDto {

    @Schema(description = "Training title", example = "Fitness")
//    @NotNull
    @NotBlank
    @NotEmpty
    @Size(max = 50)
    private String title;

    @Schema(description = "Training comments", example = "What have bin done")
//    @NotNull
    @NotBlank
    @NotEmpty
    @Size(max = 1000)
    private String description;

    @Schema(description = "minutes of training", example = "15")
    @Min(1)
//    @Size(max = 20)
    private Integer timeMinute;

    @Schema(description = "hours of training", example = "1")
//    @NotEmpty
    @Min(0)
    private Integer timeHour;

    @Schema(description = "date", example = "2024-02-02")
    @Pattern(regexp = "^(?:(?:19|20)\\d\\d)-(?:0[1-9]|1[0-2])-(?:0[1-9]|1\\d|2\\d|3[0-1])$")
    private String date;

    @Schema(description = "burned calorie", example = "250")
    @Min(1)
    private Integer calorie;

    @Schema(description = "distance of j", example = "5000")
    @Min(1)
    private Integer distance;

    @Schema(description = "type of exercises", example = "CARDIO")
    private Fitlio.FitType fitType;
}
