package baseball;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

class HintTest {

    @Test
    void emptyMap() {
        Map<Hint, Integer> hints = Hint.emptyMap();

        assertAll(
            () -> assertThat(hints).hasSize(3),
            () -> assertThat(hints).allSatisfy((hint, count) -> assertThat(count).isZero())
        );
    }
}