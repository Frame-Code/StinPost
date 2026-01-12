package ValueObjects.User;

import exceptions.DomainException;

public record UserName(String value) {
    public UserName {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("El nombre/apellido no puede estar vacío");
        }
        if (value.length() < 2 || value.length() > 50) {
            throw new DomainException("El nombre/apellido debe tener entre 2 y 50 caracteres");
        }
    }
}
