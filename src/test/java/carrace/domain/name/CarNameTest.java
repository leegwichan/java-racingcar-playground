package carrace.domain.name;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarNameTest {

    @DisplayName("이름 유효성 검사")
    @Nested
    class ValidationTest {

        @DisplayName("이름은 빈칸이어서는 안된다")
        @ParameterizedTest
        @CsvSource(value = {"''", "' '", "'  '"})
        void validationTest_whenNameIsBlank_throwException(String blankName) {
            assertThatThrownBy(() -> CarName.from(blankName))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("이름은 빈칸이 아닌 글자가 하나 이상이어야 합니다");
        }

        @DisplayName("이름은 null이어서는 안된다")
        @Test
        void validationTest_whenNameIsNull_throwException() {
            assertThatThrownBy(() -> CarName.from(null))
                    .isInstanceOf(NullPointerException.class)
                    .hasMessageContaining("이름은 null이 아니너야 합니다");
        }

        @DisplayName("이름이 글자가 초과되어서는 안된다")
        @ParameterizedTest
        @CsvSource(value = {"김수한무거북이", "christina", "steven"})
        void validationTest_whenNameLengthIsOverThan5_throwException(String name) {
            assertThatThrownBy(() -> CarName.from(name))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("이름은 5글자를 초과해서는 안됩니다");
        }
    }
}