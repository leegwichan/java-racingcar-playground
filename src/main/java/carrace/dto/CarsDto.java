package carrace.dto;

import java.util.List;
import java.util.Objects;

public final class CarsDto {
    private final List<CarDto> carDtos;

    public CarsDto(List<CarDto> carDtos) {
        this.carDtos = Objects.requireNonNull(carDtos);
    }

    public static CarsDto of(List<CarDto> carDtos) {
        return new CarsDto(carDtos);
    }

    public List<CarDto> getCarDtos() {
        return List.copyOf(carDtos);
    }
}
