package carrace.domain.movingstrategy.random;

import java.util.Random;

public class RandomIntImpl implements RandomInt {

    private static final Random RANDOM = new Random();

    @Override
    public int create(int min, int max) {
        return RANDOM.nextInt(max - min) + min;
    }
}
