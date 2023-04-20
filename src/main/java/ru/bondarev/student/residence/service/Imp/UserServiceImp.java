package ru.bondarev.student.residence.service.Imp;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.bondarev.student.residence.dto.request.UserRequest;
import ru.bondarev.student.residence.entity.User;
import ru.bondarev.student.residence.repositories.UserRepository;
import ru.bondarev.student.residence.service.UserService;

@Service
@RequiredArgsConstructor

public class UserServiceImp implements UserService {
    private  final UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public void saveUser(UserRequest userRequest) {
        var user = User.builder()
                .login(userRequest.getLogin())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .role("ROLE_USER")
                .build();

        userRepository.save(user);
    }

}
