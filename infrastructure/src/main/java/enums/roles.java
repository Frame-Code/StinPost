package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum roles {
    ADMINISTRADOR("Administrador"),
    SUBSCRIBER ("Subscriber");

    private final String description;
}
