package de.ait.fitlio.security.details;

import de.ait.fitlio.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthenticatedUserService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        /*

        Optional<User> userOptional = usersRepository.findByEmail(email); // находим пользователя по email-у

        if (userOptional.isPresent()) { // если пользователь найден
            User user = userOptional.get(); // получаем непосредственно объект пользователя
            AuthenticatedUser authenticatedUser = new AuthenticatedUser(user); // кладем пользователя в объект для Spring Security
            return authenticatedUser; // возвращаем результат работы метода - пользователь из базы данных, адаптированный для Spring Security
        } else {
            // если пользователя не нашли - возвращаем ошибку
            throw new UsernameNotFoundException(("User with email <" + email + "> not found"));
        }

         */
        return new AuthenticatedUser(userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User with Email <" + email + "> not found")));
    }
}
