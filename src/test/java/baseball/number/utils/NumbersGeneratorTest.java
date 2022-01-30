package baseball.number.utils;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;

import baseball.number.domain.BaseballNumber;
import baseball.number.domain.BaseballNumbers;

class NumbersGeneratorTest {

    @Test
    void generate() {
        BaseballNumbers baseballNumbers = NumbersGenerator.generate();

        List<BaseballNumber> numbers = baseballNumbers.getNumbers();

        assertAll(
            () -> assertThat(numbers).hasSize(3),
            () -> assertThat(new HashSet<>(numbers)).hasSize(3)
        );
    }
}