package carrace.domain.movingstrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarMovingStrategyTest {

    @DisplayName("객체 생성 테스트")
    @Nested
    class CreationTest {

        @DisplayName("인자가 null인 경우 예외를 던짐")
        @Test
        void creationTest_whenCreateWithNull_throwException() {
            assertThatThrownBy(() -> new CarMovingStrategy(null))
                    .isInstanceOf(NullPointerException.class);
        }

        @DisplayName("팩토리 메서드 패턴을 통해 객체를 정상적으로 생성한다")
        @Test
        void creationTest() {
            CarMovingStrategy strategy = CarMovingStrategy.from();

            assertThat(strategy).isNotNull();
        }
    }
}