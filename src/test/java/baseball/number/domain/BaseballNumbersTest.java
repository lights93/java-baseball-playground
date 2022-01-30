package baseball.number.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
    @ValueSource(strings = {"111", "112"})
    void constructDuplicateError(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> BaseballNumbers.from(input))
            .withMessage("중복된 숫자없이 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int number) {
        BaseballNumbers baseballNumbers = BaseballNumbers.from("123");

        assertThat(baseballNumbers.contains(BaseballNumber.from(number))).isTrue();
    }

    @Test
    void containsFalse() {
        BaseballNumbers baseballNumbers = BaseballNumbers.from("123");

        assertThat(baseballNumbers.contains(BaseballNumber.from(4))).isFalse();
    }

    @ParameterizedTest
    @CsvSource({"1,0", "2,1", "3,2"})
    void hasSamePlace(int number, int place) {
        BaseballNumbers baseballNumbers = BaseballNumbers.from("123");

        assertThat(baseballNumbers.hasSamePlace(BaseballNumber.from(number), place)).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"1,1", "1,2", "4,1"})
    void hasSamePlaceFalse(int number, int place) {
        BaseballNumbers baseballNumbers = BaseballNumbers.from("123");

        assertThat(baseballNumbers.hasSamePlace(BaseballNumber.from(number), place)).isFalse();
    }
}