package ceos.study.vote.global.apiPayload.code.status;

import ceos.study.vote.global.apiPayload.code.BaseCode;
import ceos.study.vote.global.apiPayload.code.ReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseCode {

    // 기본 에러 응답
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러."),
    BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
    FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),

    // 유저 관련 에러 응답
    USER_ALREADY_EXISTS(HttpStatus.BAD_REQUEST, "USER ALREADY EXISTS", "유저가 이미 존재합니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "USER NOT FOUND", "유저를 찾을 수 없습니다."),

    // 로그인 관련 에러 응답
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "INVALID TOKEN", "토큰이 유효하지 않습니다."),
    EXPIRED_TOKEN(HttpStatus.UNAUTHORIZED, "EXPIRED TOKEN", "만료된 토큰입니다."),
    UNSUPPORTED_TOKEN(HttpStatus.UNAUTHORIZED, "UNSUPPORTED TOKEN", "지원하지 않는 토큰입니다."),
    REDIS_KEY_NOT_FOUND(HttpStatus.NOT_FOUND, "REDIS KEY NOT FOUND", "요청한 키가 Redis에 존재하지 않습니다."),
    INVALID_SIGNATURE(HttpStatus.UNAUTHORIZED, "INVALID SIGNATURE", "잘못된 JWT 서명입니다");


    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ReasonDTO getReason() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ReasonDTO getReasonHttpStatus() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();
    }
}
