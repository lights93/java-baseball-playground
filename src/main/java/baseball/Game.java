package baseball;

public class Game {
    public static void main(String[] args) {
        Game game = new Game();
        game.init();
    }

    public void init() {
        Output.askInput();

        Computer computer = new Computer("123");
        findAnswer(computer);

        // TODO
    }

    public void findAnswer(Computer computer) {
        String inputNumber = Input.getInputNumber();
        HintResult hintResult = computer.calculateHint(inputNumber);
        if (!hintResult.isAnswer()) {
            findAnswer(computer);
        }
    }
}
