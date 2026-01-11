package ValueObjects.Comment;

public record CommentId(Long id) {
    public CommentId {
        if (id == null || id <= 0){
            throw new IllegalArgumentException("El ID del comentario no puede ser nulo o menor a 0");
        }

    }
}
