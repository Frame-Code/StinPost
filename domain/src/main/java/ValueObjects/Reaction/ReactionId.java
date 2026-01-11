package ValueObjects.Reaction;

public record ReactionId(Long id) {
    public ReactionId {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("El id no puede ser nulo o menor a 0");
        }
    }
}
