package stringcalculator;

public class StringAddCalculator {

    private static final int DEFAULT = 0;

    private StringAddCalculator() {
    }

    public static int splitAndSum(String expression) {
        if (isBlank(expression)) {
            return DEFAULT;
        }
        return Integer.parseInt(expression);
    }

    private static boolean isBlank(String expression) {
        return expression == null || expression.isBlank();
    }
}
