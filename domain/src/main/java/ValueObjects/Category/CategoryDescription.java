package ValueObjects.Category;

import exceptions.BussinesException;

public record CategoryDescription(String description) {
    public CategoryDescription {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("La descripción de la categoría no puede estar vacía");
        }

        if (description.length() > 200){
            throw new BussinesException("La descripción de la categoría no puede exceder los 200 caracteres");
        }
    }
}
