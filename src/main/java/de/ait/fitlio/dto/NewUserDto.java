package de.ait.fitlio.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewUserDto {
    public enum Role {
        USER, MANAGER, ADMIN
    }

    private String name;
    private String email;
    private String password;
    private Role role;
}
