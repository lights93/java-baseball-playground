package baseball;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

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
    @ValueSource(strings = {"111", "112"})
    void constructDuplicateError(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> BaseballNumbers.from(input))
            .withMessage("중복된 숫자없이 입력해주세요.");
    }

    @Test
    void getHint() {
        BaseballNumbers baseballNumbers = BaseballNumbers.from("123");

        assertAll(
            () -> assertThat(baseballNumbers.getHint(BaseballNumber.from(1), 0)).isEqualTo(Hint.STRIKE),
            () -> assertThat(baseballNumbers.getHint(BaseballNumber.from(3), 1)).isEqualTo(Hint.BALL),
            () -> assertThat(baseballNumbers.getHint(BaseballNumber.from(4), 2)).isEqualTo(Hint.NOTHING)
        );
    }
}