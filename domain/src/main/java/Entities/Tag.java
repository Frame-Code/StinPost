package Entities;

import ValueObjects.Tag.TagId;
import ValueObjects.Tag.TagName;

import java.util.Objects;

public class Tag {
    private final TagId tagId;
    private final TagName tagName;

    private Tag(TagId tagId, TagName tagName) {
        if(tagId == null) throw new IllegalArgumentException("El id del tag no puede ser nulo");
        if(tagName == null) throw new IllegalArgumentException("El nombre del tag no puede ser nulo");

        this.tagId = tagId;
        this.tagName = tagName;
    }

    public static Tag create(TagId tagId, TagName tagName) {
        return new Tag(tagId, tagName);
    }

    public static Tag restore(TagId tagId, TagName tagName){
        return new Tag(tagId, tagName);
    }

    public TagId getTagId() {
        return tagId;
    }

    public TagName getTagName() {
        return tagName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return Objects.equals(tagId, tag.tagId);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
