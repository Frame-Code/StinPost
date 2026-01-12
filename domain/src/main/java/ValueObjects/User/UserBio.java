package ValueObjects.User;

import exceptions.DomainException;

public record UserBio(String value) {
    public UserBio {
        if (value.length() < 2 || value.length() > 255) {
            throw new DomainException("La biografía no puede exceder los 255 caracteres");
        }

    }
    
    // Método factory para manejar nulos como vacíos si se desea
    public static UserBio of(String value) {
        return new UserBio(value == null ? "" : value);
    }
}
