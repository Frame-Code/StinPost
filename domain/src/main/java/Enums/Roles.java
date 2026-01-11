package Enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Roles {
    ADMINISTRADOR("Administrador"),
    SUBSCRIBER("Subscriber");

    private final String description;
}