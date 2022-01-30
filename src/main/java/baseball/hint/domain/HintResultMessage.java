package baseball.hint.domain;

import baseball.number.domain.BaseballNumbers;

public class HintResultMessage {
    private static final String SPACE = " ";
    private static final int ZERO = 0;
    private final String message;

    private HintResultMessage(HintResult hintResult) {
        this.message = makeMessage(hintResult);
    }

    private String makeMessage(HintResult hintResult) {
        int nothingCount = hintResult.getNothingCount();
        if (nothingCount == BaseballNumbers.SIZE) {
            return Hint.NOTHING.getKoreanName();
        }

        int ballCount = hintResult.getBallCount();
        int strikeCount = hintResult.getStrikeCount();

        return makeMessage(ballCount, strikeCount);
    }

    private String makeMessage(int ballCount, int strikeCount) {
        if (ballCount == ZERO) {
            return strikeCount + Hint.STRIKE.getKoreanName();
        }

        if (strikeCount == ZERO) {
            return ballCount + Hint.BALL.getKoreanName();
        }

        return ballCount + Hint.BALL.getKoreanName() + SPACE + strikeCount + Hint.STRIKE.getKoreanName();
    }

    public static HintResultMessage from(HintResult hintResult) {
        return new HintResultMessage(hintResult);
    }

    public String getMessage() {
        return message;
    }
}
