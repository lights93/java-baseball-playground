package baseball;

public class Game {
    public static void main(String[] args) {
        Game game = new Game();
        game.init();
    }

    public void init() {
        GameStatus gameStatus = GameStatus.PLAY;

        while (gameStatus.isPlay()) {
            Computer computer = new Computer("123");
            findAnswer(computer);

            Output.printEndMessage();
            gameStatus = GameStatus.from(Input.getGameStatus());
        }
    }

    public void findAnswer(Computer computer) {
        Output.askInput();
        HintResult hintResult = computer.calculateHint(Input.getInputNumber());
        Output.printHintResultMessage(HintResultMessage.from(hintResult));
        if (!hintResult.isAnswer()) {
            findAnswer(computer);
        }
    }
}
