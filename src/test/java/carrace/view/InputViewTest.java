package carrace.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import carrace.view.printer.Printer;
import carrace.view.printer.SpyPrinter;
import carrace.view.reader.MockReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputViewTest {

    @DisplayName("시도 횟수를 입력받을 수 있다")
    @Nested
    class PlayCountTest {

        @DisplayName("양수 외의 문자를 입력하면 예외를 던진다")
        @ParameterizedTest(name = "{0}")
        @CsvSource({"+-", "13r", "0", "-1"})
        void inputPlayCountTest_whenInputNotMatched_throwException(String inputMessage) {
            InputView inputView = createMockInputView(inputMessage);

            assertThatThrownBy(() -> inputView.inputPlayCount())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("양수를 입력하여야 합니다");
        }

        @DisplayName("입력 메세지와 함께 양수를 입력하면 해당 숫자를 반환한다")
        @ParameterizedTest(name = "{0}")
        @CsvSource({"1", "10"})
        void inputPlayCountTest(String inputMessage) {
            SpyPrinter printer = new SpyPrinter();
            InputView inputView = createMockInputView(inputMessage, printer);
            int expected = Integer.parseInt(inputMessage);

            int actual = inputView.inputPlayCount();

            assertThat(printer.gerPrintedMessage()).contains("시도할 회수는 몇회인가요?");
            assertThat(actual).isEqualTo(expected);
        }
    }

    InputView createMockInputView(String inputMessage) {
        return createMockInputView(inputMessage, new SpyPrinter());
    }

    InputView createMockInputView(String inputMessage, Printer printer) {
        return InputView.of(new MockReader(inputMessage), printer);
    }
}