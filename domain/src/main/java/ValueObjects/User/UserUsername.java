package ValueObjects.User;

import exceptions.DomainException;

public record UserUsername(String value) {
    public UserUsername {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("El nombre de usuario no puede estar vacío");
        }
        if (value.length() < 4 || value.length() > 16) {
            throw new DomainException("El nombre de usuario debe tener entre 4 y 16 caracteres");
        }
        if (value.contains(" ")) {
            throw new DomainException("El nombre de usuario no puede contener espacios");
        }
    }
}
