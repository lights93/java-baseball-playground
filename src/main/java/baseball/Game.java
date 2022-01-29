package baseball;

public class Game {
    public static void main(String[] args) {
        Game game = new Game();
        game.init();
    }

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
            Output.printPlayOrEndErrorMessage();
            return getGameStatus();
        }
    }

    public void findAnswer(Computer computer) {
        Output.askInput();
        String inputNumber = Input.getInputNumber();
        HintResult hintResult = computer.calculateHint(BaseballNumbers.from(inputNumber));
        Output.printHintResultMessage(HintResultMessage.from(hintResult));
        if (!hintResult.isAnswer()) {
            findAnswer(computer);
        }
    }
}
