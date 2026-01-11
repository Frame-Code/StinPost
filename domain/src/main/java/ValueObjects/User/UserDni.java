package ValueObjects.User;

import exceptions.BussinesException;

public record UserDni(String value) {
    public UserDni {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("El DNI no puede estar vacío");
        }
        if (value.length() != 10) {
            throw new BussinesException("El DNI debe tener exactamente 10 caracteres");
        }
        if (!value.matches("\\d+")) {
            throw new BussinesException("El DNI debe contener solo números");
        }
    }
}
