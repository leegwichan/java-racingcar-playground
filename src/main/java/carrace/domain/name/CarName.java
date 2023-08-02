package carrace.domain.name;

import java.util.Objects;

public final class CarName implements Name {

    private static final int MAX_LENGTH = 5;

    private final String name;

    private CarName(String name) {
        validate(name);
        this.name = name.trim();
    }

    void validate(String name) {
        Objects.requireNonNull(name, "이름은 null이 아니너야 합니다");
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름은 빈칸이 아닌 글자가 하나 이상이어야 합니다");
        }
        if (name.trim().length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 5글자를 초과해서는 안됩니다");
        }
    }

    public static CarName from(String name) {
        return new CarName(name);
    }

    @Override
    public String getName() {
        return this.name;
    }
}