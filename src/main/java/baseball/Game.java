package baseball;

public class Game {
    public void init() {
        Output.askInput();
        String inputNumber = Input.getInputNumber();
        Computer computer = new Computer("123");
        HintResult hintResult = computer.calculateHint(inputNumber);
        // TODO
    }
}
