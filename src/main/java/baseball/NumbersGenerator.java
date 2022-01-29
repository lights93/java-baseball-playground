package baseball;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class NumbersGenerator {
    private static final Random random = new Random();
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int MAX_SIZE = 3;

    private NumbersGenerator() {
    }

    public static BaseballNumbers generate() {
        List<BaseballNumber> numbers = random.ints(MIN_NUMBER, MAX_NUMBER)
            .distinct()
            .limit(MAX_SIZE)
            .mapToObj(BaseballNumber::from)
            .collect(Collectors.toList());

        return BaseballNumbers.from(numbers);
    }
}
