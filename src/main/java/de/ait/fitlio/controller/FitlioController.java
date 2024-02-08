package de.ait.fitlio.controller;

import de.ait.fitlio.dto.FitlioDto;
import de.ait.fitlio.dto.NewFitlioDto;
import de.ait.fitlio.dto.StandardResponseDto;
import de.ait.fitlio.service.FitlioService;
import de.ait.fitlio.validation.dto.ValidationErrorsDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/fitlio")
@Tags(value = {
        @Tag(name = "fitlio"),
        @Tag(name = "v 0.1")
})
public class FitlioController {

    private final FitlioService fitlioService;

    @Operation(summary = "Create a Fitlio", description = "Only admin")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Fitlio was created successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FitlioDto.class))),
            @ApiResponse(responseCode = "400",
                    description = "Validation error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ValidationErrorsDto.class)))
    })
    @PostMapping
    public ResponseEntity<FitlioDto> addFitlio(@RequestBody @Valid NewFitlioDto newFitlio) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(fitlioService.addFitlio(newFitlio));
    }

    @Operation(summary = "Getting the Fitlio list", description = "Available to all users")
    @GetMapping
    public ResponseEntity<List<FitlioDto>> getFitlios() {
        return ResponseEntity
                .ok(fitlioService.getAllFitlio());
    }
    @Operation(summary = "Getting fitlio", description = "Available to all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Request processed successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = FitlioDto.class))
            ),
            @ApiResponse(responseCode = "404",
                    description = "Курс не найден",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StandardResponseDto.class)))
    })
    @GetMapping("/{fitlio-id}")
    public FitlioDto getFitlio(@Parameter(description = "identifier fitlio", example = "1")
                               @PathVariable("fitlio-id") Long fitlioId) {
        return fitlioService.getFitlioById(fitlioId);
    }
}
