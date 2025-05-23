package ceos.study.vote.domain.user.converter;

import ceos.study.vote.domain.user.dto.UserRequestDto;
import ceos.study.vote.domain.user.dto.UserResponseDto;
import ceos.study.vote.domain.user.entity.RoleType;
import ceos.study.vote.domain.user.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserConverter {
    public static User toUser(UserRequestDto.SignUpRequestDto request, PasswordEncoder passwordEncoder) {
        return User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .team(request.getTeam())
                .part(request.getPart())
                .roleType(RoleType.USER)
                .build();
    }

    public static UserResponseDto.ResultDto toResultDto(User user) {
        return UserResponseDto.ResultDto.builder()
                .id(user.getId())
                .build();
    }
}
