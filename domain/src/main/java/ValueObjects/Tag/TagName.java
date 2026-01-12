package ValueObjects.Tag;

import exceptions.DomainException;

public record TagName(String name) {
    public TagName {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("El nombre del tag  no puede ser nulo");
        }

        if (name.length() > 50){
            throw new DomainException("El nombre del tag no puede exceder los 50 caracteres");
        }
    }
}
