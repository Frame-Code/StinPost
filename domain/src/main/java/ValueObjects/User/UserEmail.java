package ValueObjects.User;

import exceptions.DomainException;

import java.util.regex.Pattern;

public record UserEmail(String value) {
    // Regex simple para email
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

    public UserEmail {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("El email no puede estar vacío");
        }
        if (!EMAIL_PATTERN.matcher(value).matches()) {
            throw new DomainException("El formato del email es inválido");
        }
    }
}
