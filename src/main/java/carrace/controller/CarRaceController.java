package carrace.controller;

import carrace.domain.Cars;
import carrace.view.InputView;
import carrace.view.OutputView;
import java.util.Objects;

public class CarRaceController {

    private final InputView inputView;
    private final OutputView outputView;
    private Cars cars;

    private CarRaceController(InputView inputView, OutputView outputView) {
        this.inputView = Objects.requireNonNull(inputView);
        this.outputView = Objects.requireNonNull(outputView);
    }

    public static CarRaceController of(InputView inputView, OutputView outputView) {
        return new CarRaceController(inputView, outputView);
    }

    public void run() {
        cars = Cars.of(inputView.inputCarNames());
        int count = inputView.inputPlayCount();

        printCarProgress(count);
        outputView.printCarRaceResult(cars.getProgress());
    }

    private void printCarProgress(int count) {
        outputView.printResultTitle();
        for (int currentCount = count; currentCount > 0; currentCount--) {
            cars.move();
            outputView.printCarsLocation(cars.getProgress());
        }
    }
}
