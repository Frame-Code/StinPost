package ValueObjects.Post;

public record PostId(Long id) {
    public PostId {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("El ID del post no puede ser nulo o negativo");
        }
    }
}
