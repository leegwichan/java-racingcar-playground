package carrace.domain;

import carrace.domain.location.CarLocation;
import carrace.domain.location.Location;
import carrace.domain.movingstrategy.CarMovingStrategy;
import carrace.domain.movingstrategy.MovingStrategy;
import carrace.domain.name.CarName;
import carrace.domain.name.Name;
import java.util.Objects;

public final class Car {

    private final MovingStrategy movingStrategy;
    private final Name name;
    private Location location;


    Car(MovingStrategy movingStrategy, Name name, Location location) {
        this.movingStrategy = Objects.requireNonNull(movingStrategy);
        this.name = Objects.requireNonNull(name);
        this.location = Objects.requireNonNull(location);
    }

    public static Car of(String name) {
        return new Car(CarMovingStrategy.from(), CarName.from(name), CarLocation.from());
    }

    public void move() {
        if (movingStrategy.isMoved()) {
            location = location.move();
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getLocation() {
        return location.getLocation();
    }
}
