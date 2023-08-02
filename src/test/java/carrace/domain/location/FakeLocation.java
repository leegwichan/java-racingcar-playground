package carrace.domain.location;

public class FakeLocation implements Location {

    private int location;

    private FakeLocation(int location) {
        this.location = location;
    }

    public static FakeLocation from(int initLocation) {
        return new FakeLocation(initLocation);
    }

    @Override
    public Location move() {
        location++;
        return this;
    }

    @Override
    public int getLocation() {
        return location;
    }
}
