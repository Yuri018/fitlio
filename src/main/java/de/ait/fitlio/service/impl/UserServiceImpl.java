package de.ait.fitlio.service.impl;

import de.ait.fitlio.dto.NewUserDto;
import de.ait.fitlio.dto.UserDto;
import de.ait.fitlio.model.User;
import de.ait.fitlio.repository.UserRepository;
import de.ait.fitlio.service.UserService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

import static de.ait.fitlio.dto.UserDto.from;

@RequiredArgsConstructor
@Service
@Builder
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    //TODO прикрутить PasswordEncoder
    @Override
    public UserDto addUser(NewUserDto newUser) {

        User user = User.builder()
                .name(newUser.getName())
                .email(newUser.getEmail())
                .password(newUser.getPassword())
                .role(User.Role.USER)
                .build();
        userRepository.save(user);

        return from(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return from(userRepository.findAll());
    }
}
