package baseball;

import java.util.Map;
import java.util.Objects;

public class HintResult {
    private final Map<Hint, Integer> hints;

    private HintResult(Map<Hint, Integer> hints) {
        this.hints = hints;
    }

    public static HintResult from(Map<Hint, Integer> hints) {
        return new HintResult(hints);
    }

    public int getBallCount() {
        return hints.get(Hint.BALL);
    }

    public int getStrikeCount() {
        return hints.get(Hint.STRIKE);
    }

    public boolean isAnswer() {
        return hints.get(Hint.STRIKE) == BaseballNumbers.SIZE;
    }

    public int getNothingCount() {
        return hints.get(Hint.NOTHING);
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
}
