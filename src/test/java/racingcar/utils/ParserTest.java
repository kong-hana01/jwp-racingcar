package racingcar.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.exception.CommaNotFoundException;
import racingcar.exception.ExceptionInformation;

class ParserTest {

    @DisplayName(",로 문자열을 분리할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"kong,hana,d:3", "ethan,1:2", "kong,:1", "kong,,:1"}, delimiter = ':')
    void sliceStringByComma_success(String target, int expectedCount) {
        Parser parser = new Parser();
        Assertions.assertThat(parser.sliceByComma(target).size()).isEqualTo(expectedCount);
    }

    @DisplayName(",가 없으면 문자열을 분리할 수 없다.")
    @Test
    void sliceStringByComma_success() {
        Parser parser = new Parser();

        String target = "콩하나입니다.";
        Assertions.assertThatThrownBy(() -> parser.sliceByComma(target))
                .isInstanceOf(CommaNotFoundException.class)
                .hasMessageContaining(ExceptionInformation.NOT_FOUND_COMMA.getExceptionMessage());
    }
}
