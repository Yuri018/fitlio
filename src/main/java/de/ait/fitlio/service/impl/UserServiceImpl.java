package de.ait.fitlio.service.impl;

import de.ait.fitlio.dto.NewUserDto;
import de.ait.fitlio.dto.UserDto;
import de.ait.fitlio.model.User;
import de.ait.fitlio.model.UserProfile;
import de.ait.fitlio.repository.UserRepository;
import de.ait.fitlio.service.UserProfileService;
import de.ait.fitlio.service.UserService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import static de.ait.fitlio.dto.UserDto.from;

@RequiredArgsConstructor
@Service
//@Builder
public class UserServiceImpl implements UserService {

    //TODO прикрутить PasswordEncoder
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private final UserRepository userRepository;
    private final UserProfileService userProfileService;

    @Override
    public UserDto saveUser(NewUserDto newUser) {

        User user = User.builder()
                .name(newUser.getName())
                .email(newUser.getEmail())
                .password(passwordEncoder.encode(newUser.getPassword()))
//                .password(newUser.getPassword())
                .role(User.Role.USER)
                .build();
        userRepository.save(user);

        UserProfile userProfile = userProfileService.createUserProfileForUser(user);
        user.setUserProfile(userProfile);

        User saveUser = userRepository.save(user);

        return from(saveUser);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return from(userList);
    }
}
