package baseball.game.service;

import baseball.common.computer.Computer;
import baseball.common.console.Input;
import baseball.common.console.Output;
import baseball.game.domain.GameStatus;
import baseball.hint.domain.HintResult;
import baseball.hint.domain.HintResultMessage;
import baseball.number.domain.BaseballNumbers;
import baseball.number.utils.NumbersGenerator;

public class Game {
    public void init() {
        GameStatus gameStatus = GameStatus.PLAY;

        while (gameStatus.isPlay()) {
            BaseballNumbers baseballNumbers = NumbersGenerator.generate();
            Computer computer = new Computer(baseballNumbers);
            findAnswer(computer);

            Output.printEndMessage();
            gameStatus = getGameStatus();
        }
    }

    private GameStatus getGameStatus() {
        Output.printPlayOrEndMessage();
        try {
            return GameStatus.from(Input.getGameStatus());
        } catch (Exception e) {
            Output.printErrorMessage(e.getMessage());
            return getGameStatus();
        }
    }

    private void findAnswer(Computer computer) {
        HintResult hintResult = computer.calculateHint(getBaseballNumbers());
        Output.printHintResultMessage(HintResultMessage.from(hintResult));
        if (!hintResult.isAnswer()) {
            findAnswer(computer);
        }
    }

    private BaseballNumbers getBaseballNumbers() {
        Output.askInput();
        try {
            return BaseballNumbers.from(Input.getInputNumber());
        } catch (Exception e) {
            Output.printErrorMessage(e.getMessage());
            return getBaseballNumbers();
        }
    }
}
