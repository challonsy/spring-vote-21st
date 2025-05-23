package ceos.study.vote.domain.user.service;

import ceos.study.vote.domain.user.converter.UserConverter;
import ceos.study.vote.domain.user.dto.UserRequestDto;
import ceos.study.vote.domain.user.dto.UserResponseDto;
import ceos.study.vote.domain.user.entity.User;
import ceos.study.vote.domain.user.repository.UserRepository;
import ceos.study.vote.global.apiPayload.code.status.ErrorStatus;
import ceos.study.vote.global.apiPayload.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public User signUp(UserRequestDto.SignUpRequestDto request) {
        // 이미 유저가 있는지 확인 (이메일 안 겹치는지 확인)
        User existingUser = userRepository.findByEmail(request.getEmail()).orElse(null);
        if (existingUser != null) throw new GeneralException(ErrorStatus.USER_ALREADY_EXISTS);

        User newUser = UserConverter.toUser(request, passwordEncoder);
        userRepository.save(newUser);

        return newUser;
    }

    @Override
    @Transactional
    public UserResponseDto.ResultDto signIn(UserRequestDto.SignInRequestDto request) {
        return null;
    }
}
