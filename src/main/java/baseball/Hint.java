package baseball;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;

public enum Hint {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String koreanName;

    Hint(String koreanName) {
        this.koreanName = koreanName;
    }

    public String getKoreanName() {
        return koreanName;
    }

    public static Map<Hint, Integer> emptyMap() {
        return Arrays.stream(values())
            .collect(Collectors.toMap(
                hint -> hint,
                hint -> 0,
                Integer::sum,
                () -> new EnumMap<>(Hint.class)
            ));
    }
}
