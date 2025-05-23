package ceos.study.vote.global.redis;

import ceos.study.vote.global.apiPayload.code.status.ErrorStatus;
import ceos.study.vote.global.apiPayload.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@RequiredArgsConstructor
public class RedisService {

    private final RedisTemplate<String, Object> redisTemplate;

    public void setValue(String key, String value, Long timeout) {
        ValueOperations<String, Object> values = redisTemplate.opsForValue();
        values.set(key, value, Duration.ofMillis(timeout));
    }

    public String getValue(String key) {
        ValueOperations<String, Object> values = redisTemplate.opsForValue();
        Object value = values.get(key);
        if (value == null) {
            throw new GeneralException(ErrorStatus.REDIS_KEY_NOT_FOUND);
        }
        return value.toString();
    }

    public void deleteValue(String key) {
        redisTemplate.delete(key);
    }

    public boolean checkExistsValue(String key) {
        return redisTemplate.hasKey(key);
    }
}
