package Enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TypeReaction {
    LIKE("Like"),
    LOVE("Love"),
    FUN("Fun");
    private final String description;
}
