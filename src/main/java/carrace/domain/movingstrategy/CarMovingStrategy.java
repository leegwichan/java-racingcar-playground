package carrace.domain.movingstrategy;

import carrace.domain.movingstrategy.random.RandomInt;
import carrace.domain.movingstrategy.random.RandomIntImpl;
import java.util.Objects;

public final class CarMovingStrategy implements MovingStrategy {

    private static final int RANDOM_UPPER_BOUND = 9;
    private static final int RANDOM_LOWER_BOUND = 0;
    private static final int MOVING_LOWER_BOUND = 4;

    private final RandomInt random;

    CarMovingStrategy(RandomInt random) {
        this.random = Objects.requireNonNull(random);
    }

    public static CarMovingStrategy from() {
        return new CarMovingStrategy(new RandomIntImpl());
    }

    @Override
    public boolean isMoved() {
        int randomNumber = random.create(RANDOM_LOWER_BOUND, RANDOM_UPPER_BOUND);
        if (randomNumber < MOVING_LOWER_BOUND) {
            return false;
        }
        return true;
    }
}
