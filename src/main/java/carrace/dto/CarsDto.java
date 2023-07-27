package carrace.dto;

import java.util.List;

public final class CarsDto {
    private final List<CarDto> carDtos;

    public CarsDto(List<CarDto> carDtos) {
        this.carDtos = carDtos;
    }

    public static CarsDto of(List<CarDto> carDtos) {
        return new CarsDto(carDtos);
    }
}
