package ValueObjects.Comment;

import exceptions.BussinesException;

public record CommentContent(String content) {
    public CommentContent {
        if (content == null || content.isEmpty())   {
            throw new IllegalArgumentException("El contenido del comentario no puede estar vacío");
        }

        if (content.length() > 2000){
            throw new BussinesException("El contenido del comentario no puede exceder los 2000 caracteres");
        }
        }
    }
