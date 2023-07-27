package carrace.domain;

import carrace.dto.CarDto;
import carrace.dto.CarsDto;
import java.util.List;
import java.util.stream.Collectors;

public final class Cars {

    private final List<Car> cars;

    private Cars(List<String> names) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException("차들의 이름은 1개 이상이어야 합니다");
        }
        this.cars = names.stream()
                .map(Car::of).collect(Collectors.toList());
    }

    public static Cars of(List<String> names) {
        return new Cars(names);
    }

    public void move() {
        for (Car car : cars) {
            car.move();
        }
    }

    public CarsDto getProgress() {
        List<CarDto> carDtos = cars.stream()
                .map(car -> CarDto.of(car.getName(), car.getLocation()))
                .collect(Collectors.toList());
        return CarsDto.of(carDtos);
    }
}
