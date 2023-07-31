package carrace.dto;

public final class CarDto {

    private final String name;
    private final int location;

    private CarDto(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public static CarDto of(String name, int location) {
        return new CarDto(name, location);
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}
