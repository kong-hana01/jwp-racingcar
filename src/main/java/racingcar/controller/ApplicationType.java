package racingcar.controller;

import racingcar.exception.CannotFindApplicationTypeException;
import racingcar.exception.ExceptionMessage;

import java.util.Arrays;

public enum ApplicationType {
    CONSOLE(1),
    WEB(2);

    private final int applicationId;

    ApplicationType(int applicationId) {
        this.applicationId = applicationId;
    }

    public static ApplicationType findById(final int applicationId) {
        return Arrays.stream(values())
                .filter(applicationType -> applicationType.applicationId == applicationId)
                .findFirst()
                .orElseThrow(CannotFindApplicationTypeException::new);
    }

    public int getApplicationId() {
        return applicationId;
    }
}
