package stringcalculator;

import java.util.Arrays;

public class StringAddCalculator {

    private static final int DEFAULT = 0;
    private static final String SEPARATOR = ",";

    private StringAddCalculator() {
    }

    public static int splitAndSum(String expression) {
        if (isBlank(expression)) {
            return DEFAULT;
        }
        return Arrays.stream(expression.split(SEPARATOR))
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static boolean isBlank(String expression) {
        return expression == null || expression.isBlank();
    }
}
