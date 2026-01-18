package Ports;

import ValueObjects.Category.CategoryId;

import java.util.List;

public interface ICategoryRepository {
    boolean existsIds(List<CategoryId> ids);
}
