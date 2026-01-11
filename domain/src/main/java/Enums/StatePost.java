package Enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatePost {
    PUBLISHED("Published"),
    PENDING("Pending");

    private final String description;

}
