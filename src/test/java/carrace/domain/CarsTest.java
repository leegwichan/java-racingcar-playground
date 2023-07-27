package carrace.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {


    @DisplayName("생성시에 이름이 없을 경우 예외를 던진다")
    @Test
    void creationTest_whenNamesSizeIs0_throwException() {
        assertThatThrownBy(() -> Cars.of(null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Cars.of(List.of())).isInstanceOf(IllegalArgumentException.class);
    }

}