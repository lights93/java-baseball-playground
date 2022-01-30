package baseball.common.computer;

import java.util.List;
import java.util.Map;

import baseball.hint.domain.Hint;
import baseball.hint.domain.HintResult;
import baseball.number.domain.BaseballNumber;
import baseball.number.domain.BaseballNumbers;

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
            Hint hint = this.baseballNumbers.getHint(number, i);
            hints.put(hint, hints.getOrDefault(hint, 0) + 1);
        }

        return HintResult.from(hints);
    }
}
