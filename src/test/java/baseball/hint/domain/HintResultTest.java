package baseball.hint.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.EnumMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class HintResultTest {
    @ParameterizedTest
    @CsvSource({"2,0,1",
        "1,0,2", "1,2,0", "1,1,1",
        "0,3,0", "0,2,1", "0,1,2", "0,0,3"})
    void isNotAnswer(int strike, int ball, int nothing) {
        Map<Hint, Integer> hints = new EnumMap<>(Hint.class);
        hints.put(Hint.STRIKE, strike);
        hints.put(Hint.BALL, ball);
        hints.put(Hint.NOTHING, nothing);

        HintResult hintResult = HintResult.from(hints);

        boolean answer = hintResult.isAnswer();

        assertThat(answer).isFalse();
    }

    @Test
    void isAnswer() {
        Map<Hint, Integer> hints = new EnumMap<>(Hint.class);
        hints.put(Hint.STRIKE, 3);
        hints.put(Hint.BALL, 0);
        hints.put(Hint.NOTHING, 0);

        HintResult hintResult = HintResult.from(hints);

        boolean answer = hintResult.isAnswer();

        assertThat(answer).isTrue();
    }
}