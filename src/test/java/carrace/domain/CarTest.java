package carrace.domain;

import static org.assertj.core.api.Assertions.assertThat;

import carrace.domain.location.FakeLocation;
import carrace.domain.movingstrategy.MovingStrategy;
import carrace.domain.name.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarTest {

    @DisplayName("전략에 따라 앞으로 이동할 수 있다")
    @ParameterizedTest(name = "앞으로 가는 것이 {0}일때, 앞으로 {1}칸 간다")
    @CsvSource({"true, 1", "false, 0"})
    void moveTest_whenMovingIsAllowed(boolean isMoved, int location) {
        MovingStrategy mockMovingStrategy = () -> isMoved;
        Name mockName = () -> "steve";
        Car car = new Car(mockMovingStrategy, mockName, FakeLocation.from(0));

        car.move();

        assertThat(car.getLocation()).isEqualTo(location);
    }

    @DisplayName("이름을 초기에 설정한 대로 반환한다")
    @Test
    void getNameTest() {
        MovingStrategy mockMovingStrategy = () -> false;
        Name mockName = () -> "steve";
        Car car = new Car(mockMovingStrategy, mockName, FakeLocation.from(0));

        String actual  = car.getName();

        assertThat(actual).isEqualTo("steve");
    }

    @DisplayName("현재 위치 값을 반환한다")
    @Test
    void getLocationTest() {
        MovingStrategy mockMovingStrategy = () -> false;
        Name mockName = () -> "steve";
        Car car = new Car(mockMovingStrategy, mockName, FakeLocation.from(3));

        car.move();

        assertThat(car.getLocation()).isEqualTo(3);
    }
}