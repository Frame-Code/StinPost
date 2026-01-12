package ValueObjects.Category;

import exceptions.DomainException;

public record CategoryName(String name) {
    public CategoryName{

        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("El nombre de la categoría no puede estar vacío");
        }

        if (name.length() > 50){
            throw new DomainException("El nombre de la categoría no puede exceder los 50 caracteres");
        }
    }
}
