package carrace.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import carrace.view.printer.SpyPrinter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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
}