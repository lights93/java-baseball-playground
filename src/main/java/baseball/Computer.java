package baseball;

import java.util.Map;

public class Computer {
    private final String answer;

    public Computer(String answer) {
        this.answer = answer;
    }

    public HintResult calculateHint(String input) {
        Map<Hint, Integer> hints = Hint.emptyMap();
        for (int i = 0; i < input.length(); i++) {
            String number = input.substring(i, i + 1);
            Hint hint = getHint(number, i);
            hints.put(hint, hints.getOrDefault(hint, 0) + 1);
        }

        return HintResult.from(hints);
    }

    private Hint getHint(String number, int idx) {
        if (!answer.contains(number)) {
            return Hint.NOTHING;
        }

        if (number.equals(answer.substring(idx, idx + 1))) {
            return Hint.STRIKE;
        }

        return Hint.BALL;
    }
}
