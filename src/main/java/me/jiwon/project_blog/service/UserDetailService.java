package me.jiwon.project_blog.service;

import lombok.RequiredArgsConstructor;
import me.jiwon.project_blog.domain.User;
import me.jiwon.project_blog.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public User loadUserByUsername(String email) {
        return userRepository.findByEmail(email).orElseThrow(()->new IllegalArgumentException(email));
    }

}
