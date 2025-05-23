package ceos.study.vote.domain.user.controller;

import ceos.study.vote.domain.user.converter.UserConverter;
import ceos.study.vote.domain.user.dto.UserRequestDto;
import ceos.study.vote.domain.user.dto.UserResponseDto;
import ceos.study.vote.domain.user.entity.User;
import ceos.study.vote.domain.user.service.UserService;
import ceos.study.vote.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "유저 로그인", description = "유저 로그인 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserRestController {
    private final UserService userService;

    @PostMapping("/sign-up")
    @Operation(summary = "일반 회원가입 API")
    public ApiResponse<UserResponseDto.ResultDto> signUp(@RequestBody @Valid UserRequestDto.SignUpRequestDto request) {
        User user = userService.signUp(request);
        return ApiResponse.onSuccess(UserConverter.toResultDto(user));
    }

    @PostMapping("/sign-in")
    @Operation(summary = "일반 로그인 API")
    public ApiResponse<UserResponseDto.ResultDto> signIn(@RequestBody @Valid UserRequestDto.SignInRequestDto request) {
        return ApiResponse.onSuccess(userService.signIn(request));
    }
}
