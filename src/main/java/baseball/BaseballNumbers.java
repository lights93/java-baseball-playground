package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumbers {
    private final List<BaseballNumber> numbers;

    private BaseballNumbers(List<BaseballNumber> numbers) {
        this.numbers = numbers;
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

    public boolean contains(BaseballNumber number) {
        return numbers.contains(number);
    }

    public boolean isStrike(BaseballNumber number, int idx) {
        return number.equals(numbers.get(idx));
    }
}
