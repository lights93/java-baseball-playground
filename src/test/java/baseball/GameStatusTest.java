package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameStatusTest {

    @Test
    void isEnd() {
        assertThat(GameStatus.END.isPlay()).isFalse();
    }

    @Test
    void isPlay() {
        assertThat(GameStatus.PLAY.isPlay()).isTrue();
    }
}