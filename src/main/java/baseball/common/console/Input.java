package baseball.common.console;

import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    private Input() {
    }

    public static String getInputNumber() {
        return scanner.nextLine();
    }

    public static String getGameStatus() {
        return scanner.nextLine();
    }
}
