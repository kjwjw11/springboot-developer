package me.jiwon.project_blog.service;

import lombok.RequiredArgsConstructor;
import me.jiwon.project_blog.domain.User;
import me.jiwon.project_blog.dto.AddUserRequest;
import me.jiwon.project_blog.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest dto) {
        return userRepository.save(User.builder()
                .email(dto.getEmail())
                .password(bCryptPasswordEncoder.encode(dto.getPassword())) //패스워드 암호화
                .build()).getId();
    }

    public User findById(Long userId) {
        return userRepository.findById(userId).orElseThrow(()-> new IllegalArgumentException("Unexpected user"));
    }

}
