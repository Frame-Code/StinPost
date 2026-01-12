package Entities;

import ValueObjects.Tag.TagId;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Tag {
    @EqualsAndHashCode.Include
    private final TagId tagId;
}
