package ValueObjects.Image;

import Enums.TypeExtensionImage;
import exceptions.DomainException;

import java.util.Arrays;

public record ImageFilename(String filename) {
    public ImageFilename {
        if (filename == null || filename.isBlank()) {
            throw new IllegalArgumentException("El nombre del archivo no puede ser nulo");
        }

        boolean isValidExtension = false;
        for (TypeExtensionImage value : TypeExtensionImage.values()) {
            if (filename.toUpperCase().endsWith(value.name())) {
                isValidExtension = true;
                break;
            }
        }

        if(!isValidExtension) {
            String values = Arrays.toString(TypeExtensionImage.values()).replace("]", "").replace("[", "");
            throw new DomainException("El nombre de la imagen debe terminar en: " + values);
        }
    }
}
