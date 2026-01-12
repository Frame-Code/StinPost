package ValueObjects.Post;

import exceptions.DomainException;

public record PostTitle(String title) {
    public PostTitle {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("El titulo del post no puede estar vacío");
        }
        if (title.length() < 2 || title.length() > 200){
            throw new DomainException("El post debe tener entre 2 y 200 caracteres");
        }
    }
}
