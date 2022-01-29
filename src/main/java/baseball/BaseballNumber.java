package baseball;

import java.util.Objects;

public class BaseballNumber {
    private final int number;

    private BaseballNumber(int number) {
        this.number = number;
    }

    public static BaseballNumber from(int number) {
        return new BaseballNumber(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof BaseballNumber))
            return false;
        BaseballNumber that = (BaseballNumber)o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
