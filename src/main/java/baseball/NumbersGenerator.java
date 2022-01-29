package baseball;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class NumbersGenerator {
    private static final Random random = new Random();

    private NumbersGenerator() {
    }

    public static BaseballNumbers generate() {
        List<BaseballNumber> numbers = random.ints(BaseballNumber.MIN_NUMBER, BaseballNumber.MAX_NUMBER)
            .distinct()
            .limit(BaseballNumbers.SIZE)
            .mapToObj(BaseballNumber::from)
            .collect(Collectors.toList());

        return BaseballNumbers.from(numbers);
    }
}
