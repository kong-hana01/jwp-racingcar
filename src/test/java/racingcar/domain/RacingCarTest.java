package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.domain.TestCarMaker.makeCarByValue;

class RacingCarTest {

    @ParameterizedTest
    @DisplayName("4이상이면 움직이고 3 이하이면 움직이지 않는다.")
    @CsvSource(value = {"4:1", "3:0"}, delimiter = ':')
    void moveTest(int value, int result) {
        //given
        RacingCar car = makeCarByValue("car", value);

        //when
        car.move();

        //then
        assertThat(car.getPosition()).isEqualTo(result);
    }
}
