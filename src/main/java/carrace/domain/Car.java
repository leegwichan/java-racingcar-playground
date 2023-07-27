package carrace.domain;

import java.util.Random;

public final class Car {

    private static final int NAME_LENGTH_LIMIT = 5;
    private static final int MAX_RANDOM = 9;
    private static final int MOVING_MINIMUM = 4;

    private final Random random = new Random();
    private final String name;
    private int location = 0;

    private Car(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 1글자 이상이어야 합니다");
        }
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(String.format("이름이 %d글자 이하이어야 합니다", NAME_LENGTH_LIMIT));
        }
        this.name = name;
    }

    public static Car of(String name) {
        return new Car(name);
    }

    public void move() {
        if (random.nextInt(MAX_RANDOM) >= MOVING_MINIMUM) {
            location++;
        }
    }

    public int getLocation() {
        return location;
    }
}
