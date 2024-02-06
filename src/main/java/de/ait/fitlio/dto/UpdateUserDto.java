package de.ait.fitlio.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserDto {
    public enum Role {
        USER, MANAGER, ADMIN
    }

    private String name;
    private String email;
    private String password;
    private Role role;
}
