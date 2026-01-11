package ValueObjects.Post;

public record PostSummary(String summary) {
    public PostSummary {
        if (summary == null || summary.isEmpty()) {
            throw new IllegalArgumentException("El resumen del post no puede estar vacío");
        }
        if (summary.length() > 300){
            throw new IllegalArgumentException("El resumen del post no puede superar los 300 caracteres");
        }
    }
}
