package racingcar.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import racingcar.controller.ApplicationType;
import racingcar.entity.GameEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@JdbcTest
@Transactional
class JdbcGameDaoTestEntity {

    private GameDao gameDao;

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @BeforeEach
    void setUp() {
        gameDao = new JdbcGameDao(jdbcTemplate);
    }

    @Test
    @DisplayName("Game 테이블을 저장할 수 있다.")
    void saveGame_whenCall_thenSuccess() {
        // given
        // when, then
        assertThatCode(() -> gameDao.save(new GameEntity(10, ApplicationType.CONSOLE)))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("Game 테이블에 저장된 정보를 불러올 수 있다.")
    void findGame_whenCall_thenSuccess() {
        // given
        Long gameId = gameDao.save(new GameEntity(10, ApplicationType.CONSOLE));

        // when
        List<GameEntity> gameEntities = gameDao.findAll();

        // then
        Assertions.assertAll(
                () -> assertThat(gameEntities.size()).isEqualTo(1),
                () -> assertThat(gameEntities.get(0).getId()).isEqualTo(gameId),
                () -> assertThat(gameEntities.get(0).getTrialCount()).isEqualTo(10),
                () -> assertThat(gameEntities.get(0).getApplicationType()).isEqualTo(ApplicationType.CONSOLE)
        );
    }
}
