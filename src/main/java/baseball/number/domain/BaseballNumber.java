package baseball.number.domain;

import java.util.Objects;

public class BaseballNumber {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;

    private final int number;

    private BaseballNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number) {
        if(number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("1 ~ 9 사이의 숫자를 입력해주세요");
        }
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
