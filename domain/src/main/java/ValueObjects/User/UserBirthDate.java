package ValueObjects.User;

import exceptions.BussinesException;

import java.time.LocalDate;
import java.time.Period;

public record UserBirthDate(LocalDate value) {
    public UserBirthDate {
        if (value == null) {
            throw new IllegalArgumentException("La fecha de nacimiento es obligatoria");
        }
        if (value.isAfter(LocalDate.now())) {
            throw new BussinesException("La fecha de nacimiento no puede estar en el futuro");
        }
    }

    public int getAge() {
        return Period.between(value, LocalDate.now()).getYears();
    }
    
    public boolean isAdult() {
        return getAge() >= 18;
    }
}
