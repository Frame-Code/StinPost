package ValueObjects.Image;

import Enums.TypeExtensionImage;
import exceptions.DomainException;

import java.util.Arrays;

public record ImageUrl(String url) {
    public ImageUrl {
        if (url == null || url.isBlank()) {
            throw new IllegalArgumentException("La URL de la imagen no puede ser nula");
        }

        if(!url.startsWith("http://") && !url.startsWith("https://")) {
            throw new DomainException("La URL de la imagen debe comenzar con http:// o https://");
        }

        boolean isValidExtension = false;
        for (TypeExtensionImage value : TypeExtensionImage.values()) {
            if (url.toUpperCase().endsWith(value.name())) {
                isValidExtension = true;
                break;
            }
        }

        if(!isValidExtension) {
            String values = Arrays.toString(TypeExtensionImage.values()).replace("]", "").replace("[", "");
            throw new DomainException("La url de la imagen debe terminar en: " + values);
        }
    }
}
