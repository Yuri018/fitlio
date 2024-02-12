package de.ait.fitlio.dto;

import de.ait.fitlio.model.Fitlio;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class FitlioDto {

    private Long id;
    private String title;
    private String description;
    private Integer timeMinute;
    private Integer timeHour;
    private String date;
    private Integer calorie;
    private Integer distance;
    private String fitType;

    public static FitlioDto from(Fitlio fitlio) {

//        return new FitlioDto(fitlio.getId(), fitlio.getTitle(), fitlio.getDescription()
//                , fitlio.getTimeMinute(), fitlio.getTimeHour(), fitlio.getDate()
//                , fitlio.getCalorie(), fitlio.getDistance(), fitlio.getFitType());

        return FitlioDto.builder()
                .id(fitlio.getId())
                .title(fitlio.getTitle())
                .description(fitlio.getDescription())
                .timeMinute(fitlio.getTimeMinute())
                .timeHour(fitlio.getTimeHour())
                .date(fitlio.getDate().toString())
                .calorie(fitlio.getCalorie())
                .distance(fitlio.getDistance())
                .fitType(fitlio.getFitType().toString())
                .build();
    }

    public static List<FitlioDto> from(List<Fitlio> fitlios) {
        return fitlios.stream()
                .map(FitlioDto::from)
                .collect(Collectors.toList());

    }

}
