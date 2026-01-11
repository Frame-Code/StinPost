package ValueObjects.Post;

public record PostContent(String content) {
    public PostContent {
        if (content == null || content.isEmpty()) {
            throw new IllegalArgumentException("El contenido del post no puede estar vacío");
        }

    }
}
