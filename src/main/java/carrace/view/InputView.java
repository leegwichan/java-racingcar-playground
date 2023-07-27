package carrace.view;

import carrace.view.printer.Printer;
import carrace.view.reader.Reader;

public final class InputView {

    private static final String INPUT_PLAY_COUNT = "시도할 회수는 몇회인가요?\n";

    private final Reader reader;
    private final Printer printer;

    private InputView(Reader reader, Printer printer) {
        this.reader = reader;
        this.printer = printer;
    }

    public static InputView of(Reader reader, Printer printer) {
        return new InputView(reader, printer);
    }

    public int inputPlayCount() {
        try {
            printer.print(INPUT_PLAY_COUNT);
            return inputPositiveInteger();
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException("양수를 입력하여야 합니다");
        }
    }

    private int inputPositiveInteger() throws IllegalArgumentException {
        int number = Integer.parseInt(reader.read());
        if (number <= 0) {
            throw new IllegalArgumentException();
        }

        return number;
    }
}
