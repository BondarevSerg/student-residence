package ru.bondarev.student.residence.security;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.bondarev.student.residence.entity.User;
import ru.bondarev.student.residence.repositories.UserRepository;

@Component
@RequiredArgsConstructor
public class UserDetailsServiceImp implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = userRepository.findByLogin(username);
        if (user == null)
            throw new UsernameNotFoundException("Пользователь не найден");

        return new UserDetailsImp(user);
    }
}
