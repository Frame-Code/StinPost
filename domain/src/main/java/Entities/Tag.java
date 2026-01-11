package Entities;

import ValueObjects.Tag.TagId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Tag {
    private final TagId tagId;
}
