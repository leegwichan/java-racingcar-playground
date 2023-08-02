package carrace.domain.movingstrategy;

import carrace.domain.movingstrategy.random.RandomInt;
import carrace.domain.movingstrategy.random.RandomIntImpl;
import java.util.Objects;

public final class CarMovingStrategy implements MovingStrategy {

    private final RandomInt random;

    CarMovingStrategy(RandomInt random) {
        this.random = Objects.requireNonNull(random);
    }

    public static CarMovingStrategy from() {
        return new CarMovingStrategy(new RandomIntImpl());
    }

    @Override
    public boolean isMoved() {
        return false;
    }
}
