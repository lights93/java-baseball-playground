package baseball.hint.domain;

import java.util.List;
import java.util.Map;

import baseball.number.domain.BaseballNumber;
import baseball.number.domain.BaseballNumbers;

public class HintCalculator {
    private final BaseballNumbers baseballNumbers;

    public HintCalculator(BaseballNumbers baseballNumbers) {
        this.baseballNumbers = baseballNumbers;
    }

    public HintResult calculate(BaseballNumbers baseballNumbers) {
        Map<Hint, Integer> hints = Hint.emptyMap();

        List<BaseballNumber> numbers = baseballNumbers.getNumbers();

        for (int i = 0; i < numbers.size(); i++) {
            BaseballNumber number = numbers.get(i);
            Hint hint = getHint(number, i);
            hints.put(hint, hints.getOrDefault(hint, 0) + 1);
        }

        return HintResult.from(hints);
    }

    public Hint getHint(BaseballNumber number, int idx) {
        if (!baseballNumbers.contains(number)) {
            return Hint.NOTHING;
        }

        if (baseballNumbers.hasSamePlace(number, idx)) {
            return Hint.STRIKE;
        }

        return Hint.BALL;
    }
}
