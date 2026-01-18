package Ports;

import ValueObjects.Tag.TagId;

import java.util.List;

public interface ITagRepository {
    boolean existsIds(List<TagId> ids);
}
