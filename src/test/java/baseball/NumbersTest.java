package baseball;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumbersTest {

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void contains(int num) {
        BaseballNumbers baseballNumbers = BaseballNumbers.from("123");

        assertThat(baseballNumbers.contains(BaseballNumber.from(num))).isTrue();
    }
}