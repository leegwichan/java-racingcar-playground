package carrace.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import carrace.dto.CarDto;
import carrace.dto.CarsDto;
import carrace.view.printer.SpyPrinter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.List;

class OutputViewTest {

    @DisplayName("객체를 생성할 수 있다")
    @Nested
    class CreationTest {

        @DisplayName("받는 인자가 없는 경우 예외를 던진다")
        @Test
        void creationTest_whenParameterIsNull_throwException() {
            assertThatThrownBy(() -> OutputView.of(null))
                    .isInstanceOf(NullPointerException.class);
        }

        @DisplayName("받는 인자가 없는 경우 예외를 던진다")
        @Test
        void creationTest() {
            assertThatCode(() -> OutputView.of(new SpyPrinter()))
                    .doesNotThrowAnyException();
        }
    }

    @DisplayName("실행 결과 앞 타이틀을 출력할 수 있다")
    @Test
    void printResultTitleTest() {
        SpyPrinter printer = new SpyPrinter();
        OutputView outputView = OutputView.of(printer);

        outputView.printResultTitle();

        assertThat(printer.gerPrintedMessage()).contains("실행 결과");
    }

    @DisplayName("차의 현재 위치 상태를 출력할 수 있다")
    @Nested
    class PrintCarsLocationTest {
        @DisplayName("차 1대의 위치를 출력할 수 있다")
        @Test
        void test1() {
            SpyPrinter printer = new SpyPrinter();
            OutputView outputView = OutputView.of(printer);
            CarsDto carsDto = CarsDto.of(List.of(CarDto.of("pobi", 5)));

            outputView.printCarsLocation(carsDto);

            assertThat(printer.gerPrintedMessage()).contains("pobi : -----");
        }

        @DisplayName("차 2대의 위치를 출력할 수 있다")
        @Test
        void test2() {
            SpyPrinter printer = new SpyPrinter();
            OutputView outputView = OutputView.of(printer);
            CarsDto carsDto = CarsDto.of(List.of(
                    CarDto.of("pobi", 5), CarDto.of("nick", 3)));

            outputView.printCarsLocation(carsDto);

            assertThat(printer.gerPrintedMessage()).contains("pobi : -----", "nick : ---");
        }

        @DisplayName("차 3대의 위치를 출력할 수 있다")
        @Test
        void test3() {
            SpyPrinter printer = new SpyPrinter();
            OutputView outputView = OutputView.of(printer);
            CarsDto carsDto = CarsDto.of(List.of(CarDto.of("A", 1),
                    CarDto.of("B", 2), CarDto.of("C", 3)));

            outputView.printCarsLocation(carsDto);

            assertThat(printer.gerPrintedMessage()).contains("A : -", "B : --", "C : ---");
        }
    }

    @DisplayName("차 경주 경기의 최종 결과를 출력할 수 있다")
    @Nested
    class PrintCarRaceResultTest {

        @DisplayName("우승자가 1명인 경우 형식에 맞춰 출력할 수 있다")
        @Test
        void test1_whenWinnerIsOnlyOne() {
            SpyPrinter printer = new SpyPrinter();
            OutputView outputView = OutputView.of(printer);
            CarsDto carsDto = CarsDto.of(List.of(CarDto.of("A", 1),
                    CarDto.of("B", 2), CarDto.of("C", 3)));

            outputView.printCarRaceResult(carsDto);

            assertThat(printer.gerPrintedMessage()).contains("C가 최종 우승했습니다.");
        }

        @DisplayName("우승자가 2명인 경우 형식에 맞춰 출력할 수 있다")
        @Test
        void test2_whenWinnerIsTwoPeople() {
            SpyPrinter printer = new SpyPrinter();
            OutputView outputView = OutputView.of(printer);
            CarsDto carsDto = CarsDto.of(List.of(CarDto.of("A", 1),
                    CarDto.of("B", 3), CarDto.of("C", 3)));

            outputView.printCarRaceResult(carsDto);

            assertThat(printer.gerPrintedMessage()).contains("B, C가 최종 우승했습니다.");
        }

        @DisplayName("차가 없는 경우 예외를 던진다")
        @Test
        void test2_whenCarNotExist_throwException() {
            SpyPrinter printer = new SpyPrinter();
            OutputView outputView = OutputView.of(printer);
            CarsDto carsDto = CarsDto.of(List.of());

            assertThatThrownBy(() -> outputView.printCarRaceResult(carsDto))
                    .isInstanceOf(NullPointerException.class);
        }
    }

}