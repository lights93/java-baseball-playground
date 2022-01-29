package baseball;

public class Output {
    private Output() {
    }

    public static void askInput() {
        System.out.println("숫자를 입력해 주세요 : ");
    }

    public static void printHintResultMessage(HintResultMessage hintResultMessage) {
        System.out.println(hintResultMessage.getMessage());
    }

    public static void printEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printPlayOrEndMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void printErrorMessage(String message) {
        System.out.println("[에러] " + message);
    }
}
