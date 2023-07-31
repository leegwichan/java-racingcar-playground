package carrace.view;

import carrace.dto.CarDto;
import carrace.dto.CarsDto;
import carrace.view.printer.Printer;
import java.util.Objects;

public final class OutputView {

    private static final String RESULT_TITLE = "\n실행 결과\n";
    private static final String CAR_LOCATION_FORMAT = "%s : %s\n";
    private static final String ONE_BLOCK = "-";
    private static final String BLANK_LINE = "\n";

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

    public void printCarsLocation(CarsDto carsDto) {
        for (CarDto carDto : carsDto.getCarDtos()) {
            printCarLocation(carDto);
        }
        printer.print(BLANK_LINE);
    }

    private void printCarLocation(CarDto carDto) {
        String location = ONE_BLOCK.repeat(carDto.getLocation());
        String message = String.format(CAR_LOCATION_FORMAT, carDto.getName(), location);
        printer.print(message);
    }
}
