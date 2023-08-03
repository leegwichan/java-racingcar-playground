package carrace.domain.location;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarLocationTest {

    @DisplayName("객체의 기본 위치 값은 0이다")
    @Test
    void creationTest() {
        CarLocation location = CarLocation.from();
        int expected = 0;

        int actual = location.getLocation();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("앞으로 한 칸 움직일 수 있다")
    void moveTest() {
        Location location = CarLocation.from();
        int expected = 1;

        location = location.move();
        int actual = location.getLocation();

        assertThat(actual).isEqualTo(expected);
    }
}