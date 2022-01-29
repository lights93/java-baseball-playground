package baseball;

import java.util.Map;
import java.util.Objects;

public class HintResult {
    private static final int MAX_SIZE = 3;

    private final Map<Hint, Integer> hints;

    private HintResult(Map<Hint, Integer> hints) {
        this.hints = hints;
    }

    public static HintResult from(Map<Hint, Integer> hints) {
        return new HintResult(hints);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof HintResult))
            return false;
        HintResult that = (HintResult)o;
        return Objects.equals(hints, that.hints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hints);
    }

    public boolean isAnswer() {
        return hints.get(Hint.STRIKE) == MAX_SIZE;
    }
}
