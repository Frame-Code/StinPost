package ValueObjects.Tag;

import exceptions.BussinesException;

public record TagId(Long id) {
    public TagId {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("El ID del tag no puede ser nulo o menor a 0");
        }
    }
}
