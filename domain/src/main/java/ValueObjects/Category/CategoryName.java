package ValueObjects.Category;

import exceptions.BussinesException;

public record CategoryName(String name) {
    public CategoryName{

        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("El nombre de la categoría no puede estar vacío");
        }

        if (name.length() > 50){
            throw new BussinesException("El nombre de la categoría no puede exceder los 50 caracteres");
        }
    }
}
