package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballNumbersTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int num) {
        BaseballNumbers baseballNumbers = BaseballNumbers.from("123");

        assertThat(baseballNumbers.contains(BaseballNumber.from(num))).isTrue();
    }

    @Test
    void containsFalse() {
        BaseballNumbers baseballNumbers = BaseballNumbers.from("123");

        assertThat(baseballNumbers.contains(BaseballNumber.from(4))).isFalse();
    }

    @Test
    void isStrike() {
        BaseballNumbers baseballNumbers = BaseballNumbers.from("123");

        assertThat(baseballNumbers.isStrike(BaseballNumber.from(1), 0)).isTrue();
    }

    @Test
    void isStrikeFalse() {
        BaseballNumbers baseballNumbers = BaseballNumbers.from("123");

        assertThat(baseballNumbers.isStrike(BaseballNumber.from(1), 1)).isFalse();
    }
}