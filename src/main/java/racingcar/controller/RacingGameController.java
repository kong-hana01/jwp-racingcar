package racingcar.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import racingcar.domain.RacingCars;
import racingcar.service.RacingGameService;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Controller
public class RacingGameController {

    private final RacingGameService racingGameService;

    public RacingGameController(final RacingGameService racingGameService) {
        this.racingGameService = racingGameService;
    }

    @PostMapping("/plays")
    public ResponseEntity<GameResponse> doGame(@RequestBody final GameRequest gameRequest) {
        final RacingCars racingCars = racingGameService.run(gameRequest.getNames(), gameRequest.getCount());

        final List<String> winnerNames = racingCars.getWinnerNames();
        final String winnerName = String.join(", ", winnerNames);

        final List<RacingCarDto> racingCarsDto = racingCars.getRacingCars().stream()
                .map(racingCar -> new RacingCarDto(racingCar.getName(), racingCar.getPosition()))
                .collect(toList());

        return ResponseEntity.ok(new GameResponse(winnerName, racingCarsDto));
    }
}
