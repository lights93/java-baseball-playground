package baseball.number.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import baseball.hint.domain.Hint;

public class BaseballNumbers {
    public static final int SIZE = 3;
    private final List<BaseballNumber> numbers;

    private BaseballNumbers(List<BaseballNumber> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(List<BaseballNumber> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException("3개의 숫자만 입력해주세요.");
        }

        if (new HashSet<>(numbers).size() != SIZE) {
            throw new IllegalArgumentException("중복된 숫자없이 입력해주세요.");
        }
    }

    public static BaseballNumbers from(List<BaseballNumber> numbers) {
        return new BaseballNumbers(numbers);
    }

    public static BaseballNumbers from(String numbers) {
        List<BaseballNumber> inputs = new ArrayList<>();
        for (char c : numbers.toCharArray()) {
            inputs.add(BaseballNumber.from(Character.getNumericValue(c)));
        }

        return new BaseballNumbers(inputs);
    }

    public List<BaseballNumber> getNumbers() {
        return numbers;
    }

    public Hint getHint(BaseballNumber number, int idx) {
        if (!numbers.contains(number)) {
            return Hint.NOTHING;
        }

        if (number.equals(numbers.get(idx))) {
            return Hint.STRIKE;
        }

        return Hint.BALL;
    }
}
