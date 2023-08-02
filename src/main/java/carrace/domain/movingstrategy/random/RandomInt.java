package carrace.domain.movingstrategy.random;

@FunctionalInterface
public interface RandomInt {
    int create(int min, int max);
}
