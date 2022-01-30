package baseball.game.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameStatusTest {

    @ParameterizedTest
    @ValueSource(strings = {"0", "3", "a", ""})
    void constructError(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> GameStatus.from(input))
            .withMessage("잘못된 입력입니다. 1또는 2를 입력해주세요.");
    }

    @Test
    void isEnd() {
        assertThat(GameStatus.END.isPlay()).isFalse();
    }

    @Test
    void isPlay() {
        assertThat(GameStatus.PLAY.isPlay()).isTrue();
    }
}