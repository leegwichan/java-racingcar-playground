package carrace.domain;

import static org.assertj.core.api.Assertions.assertThat;

import carrace.domain.location.FakeLocation;
import carrace.domain.movingstrategy.MovingStrategy;
import carrace.domain.name.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("앞으로 가는 것을 허용했을 때, 앞으로 한칸 이동한다")
    @Test
    void moveTest_whenMovingIsAllowed() {
        MovingStrategy mockMovingStrategy = () -> true;
        Name mockName = () -> "steve";
        Car car = new Car(mockMovingStrategy, mockName, FakeLocation.from(0));

        car.move();

        assertThat(car.getLocation()).isEqualTo(1);
    }

    @DisplayName("앞으로 가는 것을 허용했을 때, 앞으로 한칸 이동한다")
    @Test
    void moveTest_whenMovingIsNotAllowed() {
        MovingStrategy mockMovingStrategy = () -> false;
        Name mockName = () -> "steve";
        Car car = new Car(mockMovingStrategy, mockName, FakeLocation.from(0));

        car.move();

        assertThat(car.getLocation()).isEqualTo(0);
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