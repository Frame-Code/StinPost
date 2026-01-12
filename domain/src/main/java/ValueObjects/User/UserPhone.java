package ValueObjects.User;

import exceptions.BussinesException;

import java.util.regex.Pattern;

public record UserPhone(String value) {
    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\+?[0-9]{8,15}$");

    public UserPhone {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("El teléfono no puede estar vacío");
        }
        if (!PHONE_PATTERN.matcher(value).matches()) {
            throw new BussinesException("El teléfono debe contener entre 8 y 15 dígitos");
        }
    }
}
