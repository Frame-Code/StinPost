package ValueObjects.Category;

public record CategoryId(Long id) {

    public CategoryId {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("El ID de la categoría no puede ser nulo o menor a 0");
        }
    }
}
