package me.jiwon.project_blog.service;

import lombok.RequiredArgsConstructor;
import me.jiwon.project_blog.domain.RefreshToken;
import me.jiwon.project_blog.repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken findByRefreshToken(String refreshToken){
        return refreshTokenRepository.findByRefreshToken(refreshToken).orElseThrow(()-> new IllegalArgumentException("Unexpected token"));
    }
}
