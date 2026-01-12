package ValueObjects.Comment;

import exceptions.DomainException;

public record CommentContent(String content) {
    public CommentContent {
        if (content == null || content.isEmpty())   {
            throw new IllegalArgumentException("El contenido del comentario no puede estar vacío");
        }

        if (content.length() > 2000){
            throw new DomainException("El contenido del comentario no puede exceder los 2000 caracteres");
        }
        }
    }
