package ValueObjects.Image;

public record ImageId(Long id) {
    public ImageId {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("El ID de la imagen no puede ser nulo");
        }
    }
}
