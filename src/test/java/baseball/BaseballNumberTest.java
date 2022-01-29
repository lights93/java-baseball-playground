package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 10, -1})
    void constructError(int number) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> BaseballNumber.from(number))
            .withMessage("1 ~ 9 사이의 숫자를 입력해주세요");
    }
}