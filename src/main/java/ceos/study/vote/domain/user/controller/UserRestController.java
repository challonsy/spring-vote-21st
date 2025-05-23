package ceos.study.vote.domain.user.controller;

import ceos.study.vote.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "유저 로그인", description = "유저 로그인 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserRestController {

    @GetMapping
    public ApiResponse<?> temp () {
        return ApiResponse.onSuccess("굿");
    }
}
