package techcourse.fp.mission;

import java.util.List;
import java.util.function.Predicate;

public class Calculator {

    public static int sum(List<Integer> numbers, Predicate<Integer> predicate) {
        int sum = 0;
        for (Integer number : numbers) {
            if (predicate.test(number)) {
                sum += number;
            }
        }
        return sum;
    }

    public static int sumAll(List<Integer> numbers) {
        return sum(numbers, number -> true);
    }

    public static int sumAllEven(List<Integer> numbers) {
        return sum(numbers, number -> number % 2 == 0);
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        return sum(numbers, number -> number > 3);
    }
}
