package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballNumbersTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "12", "1234", "1123"})
    void constructSizeError(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> BaseballNumbers.from(input))
            .withMessage("3개의 숫자만 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"111","112"})
    void constructduplicateError(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> BaseballNumbers.from(input))
            .withMessage("중복된 숫자없이 입력해주세요.");
    }


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