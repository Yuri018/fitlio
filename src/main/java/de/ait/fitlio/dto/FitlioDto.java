package de.ait.fitlio.dto;

import de.ait.fitlio.model.Fitlio;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FitlioDto {

    private Long id;
    private String title;
    private String description;
    private int timeMinute;
    private int timeHour;
    private LocalDate date;
    private int calorie;
    private int distance;
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
                .date(fitlio.getDate())
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
