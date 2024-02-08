package de.ait.fitlio.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Builder
@Schema(name = "Message", description = "Any message from the server")
public class StandardResponseDto {
    @Schema(description = "Possible: error message, status change, etc.", example = "incorrect data entry")
    private String message;
}
