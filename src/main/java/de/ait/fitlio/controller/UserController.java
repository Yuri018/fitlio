package de.ait.fitlio.controller;

import de.ait.fitlio.dto.FitlioDto;
import de.ait.fitlio.dto.NewUserDto;
import de.ait.fitlio.dto.StandardResponseDto;
import de.ait.fitlio.dto.UserDto;
import de.ait.fitlio.service.UserService;
import de.ait.fitlio.validation.dto.ValidationErrorsDto;
import io.swagger.v3.oas.annotations.Operation;
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
@Tags(
        @Tag(name = "Users")
)
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Operation(summary = "User registration", description = "Available to everyone. The default role is USER")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "User is registered",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserDto.class))),
            @ApiResponse(responseCode = "400",
                    description = "Validation error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ValidationErrorsDto.class))),
            @ApiResponse(responseCode = "409",
                    description = "There is already a user with this email",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = StandardResponseDto.class))),
    })
    @PostMapping()
    public ResponseEntity<UserDto> addUser(@RequestBody @Valid NewUserDto newUser) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.addUser(newUser));
    }

    @Operation(summary = "Getting the User list", description = "Available for admin only")
    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity
                .ok(userService.getAllUsers());
    }
}
