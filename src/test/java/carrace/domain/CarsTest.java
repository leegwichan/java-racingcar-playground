package carrace.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;

class CarsTest {

    private static final List<String> DEFAULT_NAMES = List.of("A", "B", "C");

    @DisplayName("생성시에 이름이 없을 경우 예외를 던진다")
    @Test
    void creationTest_whenNamesSizeIs0_throwException() {
        assertThatThrownBy(() -> Cars.of(null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Cars.of(List.of())).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("차들을 전부 움직일 수 있다")
    @Test
    void moveTest() {
        try (MockedConstruction<Car> mock = mockConstruction(Car.class)){
            Cars cars = Cars.of(DEFAULT_NAMES);

            cars.move();

            assertEveryCarCalledMoveMethod(mock);
        }
    }

    void assertEveryCarCalledMoveMethod(MockedConstruction<Car> mock) {
        for (int index = 0; index < DEFAULT_NAMES.size(); index++) {
            Car mockCar = mock.constructed().get(index);
            verify(mockCar, times(1)).move();
        }
    }


}