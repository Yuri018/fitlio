package de.ait.fitlio.dto;

import de.ait.fitlio.model.User;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@Schema(name = "Update User")
public class UpdateUserDto {

    @NotNull
    @Schema(description = "Update User name", example = "Juri")
    private String name;

    @Email
    @NotNull
    @Schema(description = "Update User email", example = "user@mail.com")
    private String email;

    @NotNull
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$")
    @Schema(description = "Update User password", example = "Qwerty007")
    private String password;

//    private User.Role role;
}
