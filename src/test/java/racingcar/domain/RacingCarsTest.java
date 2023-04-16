package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest extends TestCarMaker {

    private RacingCar pobi;
    private RacingCar honux;
    private RacingCar ethan;

    @BeforeEach
    void setUp() {
        pobi = createMoveRacingCar("pobi");
        honux = createMoveRacingCar("honux");
        ethan = createNotMoveRacingCar("ethan");
    }

    @Test
    @DisplayName("3대의 자동차를 보관하는 RacingCars가 정상 생성되는지 확인")
    void createRacingCars() {
        //given
        List<RacingCar> racingCars = List.of(pobi, honux, ethan);

        //when
        RacingCars result = new RacingCars(racingCars);

        //then
        assertThat(result.getRacingCars()).containsExactly(pobi, honux, ethan);
    }

    @Test
    @DisplayName("레이싱 게임이 한번 진행되는지 확인")
    void tryOnce() {
        //given
        List<RacingCar> racingCars = List.of(pobi, honux, ethan);

        //when
        RacingCars result = new RacingCars(racingCars);
        result.moveAll();

        //then
        List<Integer> positions = result.getRacingCars().stream()
                .map(RacingCar::getPosition)
                .collect(Collectors.toList());
        assertThat(positions).containsExactly(1, 1, 0);
    }

    @Test
    @DisplayName("레이싱 게임 우승자의 이름이 담긴 리스트를 가져온다.")
    void getWinnerName() {
        //given
        List<RacingCar> racingCars = List.of(pobi, honux, ethan);

        //when
        RacingCars result = new RacingCars(racingCars);
        result.moveAll();

        //then
        assertThat(result.getWinnerNames()).containsExactly("pobi", "honux");
    }
}
