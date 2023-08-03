package carrace.domain.location;

public final class CarLocation implements Location {

    private static final int DEFAULT = 0;

    private final int location;

    private CarLocation(int location) {
        this.location = location;
    }

    public static CarLocation from() {
        return new CarLocation(DEFAULT);
    }

    @Override
    public Location move() {
        return new CarLocation(this.location + 1);
    }

    @Override
    public int getLocation() {
        return this.location;
    }
}
