package baseball.hint.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.EnumMap;
import java.util.Map;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class HintResultMessageTest {
    @ParameterizedTest
    @CsvSource({"3스트라이크,3,0,0", "2스트라이크,2,0,1",
        "1스트라이크,1,0,2", "2볼 1스트라이크,1,2,0", "1볼 1스트라이크,1,1,1",
        "3볼,0,3,0", "2볼,0,2,1", "1볼,0,1,2", "낫싱,0,0,3"})
    void makeMessage(String message, int strike, int ball, int nothing) {
        Map<Hint, Integer> hints = new EnumMap<>(Hint.class);
        hints.put(Hint.STRIKE, strike);
        hints.put(Hint.BALL, ball);
        hints.put(Hint.NOTHING, nothing);

        HintResult hintResult = HintResult.from(hints);

        HintResultMessage hintResultMessage = HintResultMessage.from(hintResult);

        assertThat(hintResultMessage.getMessage()).isEqualTo(message);
    }
}
