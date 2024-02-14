package de.ait.fitlio.controller.api;

import de.ait.fitlio.dto.NewUserDto;
import de.ait.fitlio.dto.UserDto;
import de.ait.fitlio.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserAuthController implements UserAuthControllerApi {

    private final UserService userService;
    @Override
    public UserDto registerUser(NewUserDto createUser) {
        return userService.saveUser(createUser);
    }
}
