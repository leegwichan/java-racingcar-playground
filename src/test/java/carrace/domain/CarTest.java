package carrace.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.when;

import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedConstruction;

class CarTest {

    private static final String DEFAULT_NAME = "steve";

    @DisplayName("적절한 조건을 통해 객체를 생성할 수 있다")
    @Nested
    class CreationTest {

        @DisplayName("이름이 5글자 이상인 경우 예외를 던진다")
        @ParameterizedTest(name = "{0}")
        @CsvSource({"acacaca", "123456", "steven"})
        void creationTest_whenNameLengthIsOver5_throwException(String name) {
            assertThatThrownBy(() -> Car.of(name))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("이름이 5글자 이하이어야 합니다");
        }

        @DisplayName("이름은 null이거나 blank 이어서는 안된다")
        @ParameterizedTest
        @CsvSource(value = {"null", "''", "' '"}, nullValues = {"null"})
        void creationTest_whenNameIsBlank_throwException(String name) {
            assertThatThrownBy(() -> Car.of(name))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("이름은 1글자 이상이어야 합니다");
        }

        @DisplayName("이름 형식이 올바른 경우 정상적으로 객체를 생성한다")
        @ParameterizedTest(name = "{0}")
        @CsvSource({"steve", "pobi", "A"})
        void creationTest(String name) {
            assertThatCode(() -> Car.of(name)).doesNotThrowAnyException();
        }
    }

    @DisplayName("차들은 규칙에 따라 움직일 수 있다")
    @ParameterizedTest(name = "랜덤 값으로 {0}을 받으면 {1}칸 움직인다")
    @CsvSource({"0,0", "3,0", "4,1", "9,1"})
    void moveTest(int randomNumber, int expected) {
        try (MockedConstruction<Random> mock = mockConstruction(Random.class)) {
            Car car = Car.of(DEFAULT_NAME);
            mockingRandom(mock, randomNumber);

            car.move();

            assertThat(car.getLocation()).isEqualTo(expected);
        }
    }

    void mockingRandom(MockedConstruction<Random> mock, int stubNumber) {
        Random mockRandom = mock.constructed().get(0);
        when(mockRandom.nextInt(anyInt())).thenReturn(stubNumber);
    }
}