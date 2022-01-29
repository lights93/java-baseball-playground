package baseball;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;

public enum Hint {
    STRIKE,
    BALL,
    NOTHING;

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
