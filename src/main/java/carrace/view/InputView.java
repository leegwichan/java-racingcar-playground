package carrace.view;

import carrace.view.printer.Printer;
import carrace.view.reader.Reader;
import java.util.List;
import java.util.Objects;

public final class InputView {

    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n";
    private static final String CAR_NAME_SEPARATOR = ",";
    private static final String INPUT_PLAY_COUNT = "시도할 회수는 몇회인가요?\n";

    private final Reader reader;
    private final Printer printer;

    private InputView(Reader reader, Printer printer) {
        this.reader = Objects.requireNonNull(reader);
        this.printer = Objects.requireNonNull(printer);
    }

    public static InputView of(Reader reader, Printer printer) {
        return new InputView(reader, printer);
    }

    public List<String> inputCarNames() {
        printer.print(INPUT_CAR_NAMES);
        String inputMessage = reader.read();
        return List.of(inputMessage.split(CAR_NAME_SEPARATOR));
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
