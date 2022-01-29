package baseball;

public class Output {
    private Output() {
    }

    public static void askInput() {
        System.out.println("3개의 숫자를 입력해주세요");
    }

    public static void printHintResultMessage(HintResultMessage hintResultMessage) {
        System.out.println(hintResultMessage.getMessage());
    }
}
