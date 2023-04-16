package racingcar.domain;

public class RacingCar {

    private static final int MOVE_THRESHOLD = 4;

    private final Name name;
    private final Pickable picker;
    private int position;

    public RacingCar(final String carName, final Pickable picker) {
        this.name = new Name(carName);
        this.position = 0;
        this.picker = picker;
    }

    private RacingCar(final Name name) {
        this(name.getName(), new RandomPicker());
    }

    public static RacingCar createRandomMoveRacingCar(final Name name) {
        return new RacingCar(name);
    }

    public void move() {
        if (isMovable()) {
            position++;
        }
    }

    private boolean isMovable() {
        return picker.pickNumber() >= MOVE_THRESHOLD;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name.getName();
    }
}
