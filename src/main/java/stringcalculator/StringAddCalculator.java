package stringcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final int DEFAULT = 0;
    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_SEPARATOR_REGEX = "[,:]";
    private static final String CUSTOM_SEPARATOR_REGEX_FORMAT = "[,:]|%s";

    private StringAddCalculator() {
    }

    public static int splitAndSum(String expression) {
        if (isBlank(expression)) {
            return DEFAULT;
        }

        Matcher customDelimiterMatcher = CUSTOM_SEPARATOR_PATTERN.matcher(expression);
        if (customDelimiterMatcher.find()) {
            return calculate(customDelimiterMatcher);
        }
        return calculate(expression, DEFAULT_SEPARATOR_REGEX);
    }

    private static boolean isBlank(String expression) {
        return expression == null || expression.isBlank();
    }

    private static int calculate(Matcher customDelimiterMatcher) {
        String splitRegex = String.format(CUSTOM_SEPARATOR_REGEX_FORMAT, customDelimiterMatcher.group(1));
        String numberExpression = customDelimiterMatcher.group(2);
        return calculate(numberExpression, splitRegex);
    }

    private static int calculate(String numberExpression, String splitRegex) {
        return Arrays.stream(numberExpression.split(splitRegex)).mapToInt(Integer::parseInt).sum();
    }
}
