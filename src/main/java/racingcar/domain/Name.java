package racingcar.domain;

import racingcar.exception.NameIsOutOfBoundException;

import java.util.Objects;

public class Name {

    private static final int MAX_LENGTH = 5;
    private static final int MIN_LENGTH = 1;

    private final String name;

    public Name(final String name) {
        validateLength(name);
        this.name = name;
    }

    private void validateLength(final String name) {
        if (isWrongLength(name)) {
            throw new NameIsOutOfBoundException(name);
        }
    }

    private boolean isWrongLength(final String name) {
        return name.length() < MIN_LENGTH || name.length() > MAX_LENGTH;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

