package ValueObjects.User;

public record UserId(Long id) {
    public UserId {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("El ID del usuario no puede ser nulo o menor a 0");
        }
    }
}
