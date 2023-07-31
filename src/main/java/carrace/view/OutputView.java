package carrace.view;

import carrace.view.printer.Printer;
import java.util.Objects;

public final class OutputView {

    private final Printer printer;

    private OutputView(Printer printer) {
        this.printer = Objects.requireNonNull(printer);
    }

    public static OutputView of(Printer printer) {
        return new OutputView(printer);
    }
}
