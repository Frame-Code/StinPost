package ValueObjects.User;

import exceptions.DomainException;

public record UserPassword(String value) {
    public UserPassword {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("La contraseña no puede estar vacía");
        }
        if (value.length() < 8 || value.length() > 16) {
            throw new DomainException("La contraseña debe tener entre 8 y 16 caracteres");
        }
    }
}
