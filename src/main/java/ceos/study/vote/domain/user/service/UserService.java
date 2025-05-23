package ceos.study.vote.domain.user.service;

import ceos.study.vote.domain.user.dto.UserRequestDto;
import ceos.study.vote.domain.user.dto.UserResponseDto;
import ceos.study.vote.domain.user.entity.User;
import jakarta.validation.Valid;

public interface UserService {
    User signUp(UserRequestDto.SignUpRequestDto request);
    UserResponseDto.ResultDto signIn(UserRequestDto.SignInRequestDto request);
}
