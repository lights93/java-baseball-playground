package baseball;

import java.util.List;
import java.util.Map;

public class Computer {
    private final BaseballNumbers baseballNumbers;

    public Computer(BaseballNumbers baseballNumbers) {
        this.baseballNumbers = baseballNumbers;
    }

    public HintResult calculateHint(BaseballNumbers baseballNumbers) {
        Map<Hint, Integer> hints = Hint.emptyMap();

        List<BaseballNumber> numbers = baseballNumbers.getNumbers();

        for (int i = 0; i < numbers.size(); i++) {
            BaseballNumber number = numbers.get(i);
            Hint hint = getHint(number, i);
            hints.put(hint, hints.getOrDefault(hint, 0) + 1);
        }

        return HintResult.from(hints);
    }

    private Hint getHint(BaseballNumber number, int idx) {
        if (!baseballNumbers.contains(number)) {
            return Hint.NOTHING;
        }

        if (baseballNumbers.isStrike(number, idx)) {
            return Hint.STRIKE;
        }

        return Hint.BALL;
    }
}
