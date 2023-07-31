package carrace;

import carrace.controller.CarRaceController;
import carrace.view.InputView;
import carrace.view.OutputView;
import carrace.view.printer.ConsolePrinter;
import carrace.view.reader.ConsoleReader;

public class CarRaceApplication {

    private static final CarRaceController controller =
            CarRaceController.of(
                    InputView.of(new ConsoleReader(), new ConsolePrinter()),
                    OutputView.of(new ConsolePrinter()));

    private CarRaceApplication() {
    }

    public static void main(String[] args) {
        controller.run();
    }
}
