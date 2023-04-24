package racingcar.service.dto;

public class RacingCarDto {

    private final String name;
    private final int position;

    public RacingCarDto(final String name, final int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "RacingCarDto{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
