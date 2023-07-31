package carrace.view;

import carrace.view.printer.Printer;
import java.util.Objects;

public final class OutputView {

    private static final String RESULT_TITLE = "\n실행 결과\n";

    private final Printer printer;

    private OutputView(Printer printer) {
        this.printer = Objects.requireNonNull(printer);
    }

    public static OutputView of(Printer printer) {
        return new OutputView(printer);
    }

    public void printResultTitle() {
        printer.print(RESULT_TITLE);
    }
}
