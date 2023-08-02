package carrace.domain;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import carrace.dto.CarDto;
import carrace.dto.CarsDto;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;

class CarsTest {

    private static final List<String> DEFAULT_NAMES = List.of("A", "B", "C");
    private static final List<Integer> DEFAULT_LOCATIONS = List.of(1, 2, 3);

    @DisplayName("생성시에 이름이 없을 경우 예외를 던진다")
    @Test
    void creationTest_whenNamesSizeIs0_throwException() {
        List<String> emptyList = List.of();

        assertThatThrownBy(() -> Cars.of(null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Cars.of(emptyList)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("차들을 전부 움직일 수 있다")
    @Test
    void moveTest() {
        try (MockedConstruction<Car> mock = mockConstruction(Car.class)) {
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

    @DisplayName("현재 진행 상황을 반환할 수 있다")
    @Test
    void getProgressTest() {
        try (MockedConstruction<Car> mock = mockConstruction(Car.class)) {
            Cars cars = Cars.of(DEFAULT_NAMES);
            mockingCar(mock);

            CarsDto actual = cars.getProgress();

            assertThat(actual).usingRecursiveComparison().isEqualTo(expectedCarsDto());
        }
    }

    void mockingCar(MockedConstruction<Car> mock) {
        for (int index = 0; index < DEFAULT_NAMES.size(); index++) {
            Car mockCar = mock.constructed().get(index);
            when(mockCar.getName()).thenReturn(DEFAULT_NAMES.get(index));
            when(mockCar.getLocation()).thenReturn(DEFAULT_LOCATIONS.get(index));
        }
    }

    CarsDto expectedCarsDto() {
        List<CarDto> expectedCarDtos = IntStream.range(0, DEFAULT_NAMES.size())
                .mapToObj(index -> CarDto.of(DEFAULT_NAMES.get(index), DEFAULT_LOCATIONS.get(index)))
                .collect(toList());
        return CarsDto.of(expectedCarDtos);
    }
}